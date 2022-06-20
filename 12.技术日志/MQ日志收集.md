依赖 rabbitMq, 提供了 `AmqpAppender`

```xml
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-amqp</artifactId>
</dependency>
```



## 跨服务跟踪

Zuul网关为每个用户请求创建一个请求id

```java
public Object run() {
  RequestContext context = RequestContext.getCurrentContext();
  HttpServletRequest request = context.getRequest();

  User user = SystemTool.currentUser(jedisUtil);

  // logback 记录用户请求信息, 并将请求id添加到请求头, 以便跨服务共享
  String token = StringUtil.formatInput(request.getHeader("token"));
  String mqLogReqId = StringUtil.getUUID32();
  context.addZuulRequestHeader(MQ_LOG_REQ_ID, mqLogReqId);

  MDC.put(MQ_LOG_URI, request.getServletPath());
  MDC.put(MQ_LOG_REQ_ID, mqLogReqId);
  if (user != null) {
    MDC.put(MQ_LOG_TOKEN, token);
    MDC.put(MQ_LOG_USER_ID, String.valueOf(user.getId()) );
    MDC.put(MQ_LOG_USER_NAME, user.getName() );
  }

  // 网关其他操作,省略
}
```

feign传递请求时, 带上 requestId

```java
@Configuration
public class WebConfigurer implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate requestTemplate) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (attributes != null) {
            HttpServletRequest request = attributes.getRequest();
            String token = request.getHeader("token");
            requestTemplate.header("token", token);
            // 请求id
            String reqId = request.getHeader(RabbitMqConstant.MQ_LOG_REQ_ID);
            requestTemplate.header(RabbitMqConstant.MQ_LOG_REQ_ID, reqId);
        }
    }
}
```

后续服务取得请求时, 通过 logback MDC 记录requestId, 保持跨服务的日志关联

```java
public class LogbackMDCInterceptor implements HandlerInterceptor {

    private OperatorFacade operatorFacade;

    public LogbackMDCInterceptor(OperatorFacade operatorFacade) {
        this.operatorFacade = operatorFacade;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        MDC.put(MQ_LOG_URI, request.getServletPath());

        String mqLogReqId = StringUtil.formatInput(request.getHeader(MQ_LOG_REQ_ID));
        MDC.put(MQ_LOG_REQ_ID, mqLogReqId);

        String token = StringUtil.formatInput(request.getHeader("token"));
        User user = operatorFacade.getUser();
        if (token == null || user == null) {
            return true;
        }

        MDC.put(MQ_LOG_TOKEN, token );
        MDC.put(MQ_LOG_USER_ID, String.valueOf(user.getId()) );
        MDC.put(MQ_LOG_USER_NAME, user.getName() );
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // 移除请求信息
        MDC.remove(MQ_LOG_TOKEN);
        MDC.remove(MQ_LOG_USER_ID);
        MDC.remove(MQ_LOG_USER_NAME);
        MDC.remove(MQ_LOG_URI);
        MDC.remove(MQ_LOG_REQ_ID);
    }
}
```



## 通过 mq 记录日志

自定义日志过滤器, level 为 error 或 使用 ampqLogger 时, 记录到 mq

```java
public class AmqpLogFilter extends Filter<ILoggingEvent> {
    @Override
    public FilterReply decide(ILoggingEvent event) {
        if (event.getLevel() == Level.ERROR) {
            return FilterReply.ACCEPT;
        } else if (LoggerConstant.LOGGER_AMQP.equals(event.getLoggerName())){
            return FilterReply.ACCEPT;
        }
        return FilterReply.DENY;
    }
}
```

logback 配置添加 AmqpAppender, 各服务将消息记录到 amqpAppender

```xml
<!--  AmqpAppender 配置, 需要提供默认值, 以便 logback 初始化, 后面再通过变量赋值 -->
<springProperty scope="context" name="LOG_HOST" source="spring.rabbitmq.host" defaultValue=""/>
<springProperty scope="context" name="LOG_PORT" source="spring.rabbitmq.port" defaultValue="5672"/>
<springProperty scope="context" name="LOG_USERNAME" source="spring.rabbitmq.username" defaultValue=""/>
<springProperty scope="context" name="LOG_PASSWORD" source="spring.rabbitmq.password" defaultValue=""/>
<springProperty scope="context" name="LOG_SERVER" source="spring.application.name" defaultValue=""/>
<springProperty scope="context" name="LOG_SERVER_PORT" source="server.port" defaultValue=""/>

...

<appender name="AMQP" class="org.springframework.amqp.rabbit.logback.AmqpAppender">
  <!--Layout（纯文本）而不是格式化的JSON, 使用 ::CRM:: 作为分隔符-->
  <layout>
    <pattern>
      ${LOG_SERVER}::CRM::${LOG_SERVER_PORT}::CRM::%X{MQ_LOG_USER_ID:-0}::CRM::%X{MQ_LOG_USER_NAME:-系统操作}::CRM::%X{MQ_LOG_REQ_ID:-system-req-0}::CRM::%X{MQ_LOG_TOKEN:-system-token-0}::CRM::%X{MQ_LOG_URI:-/system-operate}::CRM::%msg
    </pattern>
  </layout>
  <host>${LOG_HOST}</host>
  <port>${LOG_PORT}</port>
  <username>${LOG_USERNAME}</username>
  <password>${LOG_PASSWORD}</password>
  <declareExchange>false</declareExchange>
  <exchangeType>direct</exchangeType>
  <exchangeName>EXCHANGE_CRM</exchangeName>
  <routingKeyPattern>KEY_LOG</routingKeyPattern>
  <generateId>true</generateId>
  <charset>UTF-8</charset>
  <durable>false</durable>
  <deliveryMode>PERSISTENT</deliveryMode>
  <filter class="com.vstecs.crm.common.utils.AmqpLogFilter"/>
</appender>

<root level="info">
  <appender-ref ref="CONSOLE" />
  <appender-ref ref="INFO_FILE" />
  <appender-ref ref="ERROR_FILE" />
  <!-- 发送日志到 mq -->
  <appender-ref ref="AMQP" />
</root>

<!--  log日志消费者的日志, 记录到控制台/文件, 但不再发送到 amqp-->
<logger name="com.vstecs.crm.system.mq.logger" level="info" additivity="false">
  <appender-ref ref="CONSOLE" />
  <appender-ref ref="INFO_FILE" />
  <appender-ref ref="ERROR_FILE" />
</logger>
```

注册消息消费者

```java
@RabbitHandler
@RabbitListener(queues = RabbitMqConstant.QUEUE_LOG)
public void logHandler(Message message, Channel channel) throws Exception {
  rabbitMqService.logConsumer(message);
  channel.basicAck(message.getMessageProperties().getDeliveryTag(), true);
}
```

具体消息处理方法

```java
public void logConsumer(Message message) {
  // 专用的 logger, 不会发送日志到 AmqpAppender
  Logger mqLogger = LoggerFactory.getLogger(LOGGER_MQ);
  String msg = new String(message.getBody());
  try {
    MessageProperties properties = message.getMessageProperties();

    String[] msgArray = msg.split("::CRM::");
    if (msgArray.length != MQ_LOG_ITEM_COUNT) {
      throw new CrmBizException("消息格式不正确");
    }

    // 非用户发起的外部 api 请求直接跳过, 不记录到数据库,
    String loggerName =  String.valueOf(properties.getHeaders().get("categoryName"));
    if (loggerName.startsWith(LoggerConstant.LOGGER_IGNORE_PREFIX)
        && Objects.equals(msgArray[3], "系统操作")) {
      return;
    }

    Date createTime = message.getMessageProperties().getTimestamp();
    SysAppLog sysAppLog = new SysAppLog();
    sysAppLog.setLevel(String.valueOf(properties.getHeaders().get("level")));
    sysAppLog.setLocation(String.valueOf(properties.getHeaders().get("location")));
    sysAppLog.setThread(String.valueOf(properties.getHeaders().get("thread")));
    sysAppLog.setLogger(loggerName);
    sysAppLog.setServer(msgArray[0]);
    sysAppLog.setPort(msgArray[1]);
    // 用户/请求信息
    sysAppLog.setUserId(Integer.valueOf(msgArray[2]));
    sysAppLog.setUserName(msgArray[3]);
    sysAppLog.setReqId(msgArray[4]);
    sysAppLog.setToken(msgArray[5]);
    sysAppLog.setUri(msgArray[6]);
    // 日志详情
    sysAppLog.setDetail(msgArray[7]);
    sysAppLog.setCreateTime(DateUtils.toStr(createTime));
    sysAppLogMapper.insert(sysAppLog);
  } catch (Exception e) {
    SysAppLog sysAppLog = new SysAppLog();
    sysAppLog.setLevel("ERROR");
    sysAppLog.setLocation("logConsumer");
    sysAppLog.setThread(Thread.currentThread().getName());
    sysAppLog.setLogger(LOGGER_MQ);
    sysAppLog.setServer("crm-system");
    sysAppLog.setPort("8002");
    if (e instanceof CrmBizException) {
      mqLogger.error("日志队列消费失败: {}", e.getMessage());
      sysAppLog.setDetail("消费日志发生异常, 消息原文: \n" + msg + "\n>>>>>>>>>异常内容>>>>>>>>:\n" + e.getMessage());
    } else {
      mqLogger.error("日志队列消费失败: ", e);
      sysAppLog.setDetail("消费日志发生异常, 消息原文: \n" + msg + "\n>>>>>>>>>异常内容>>>>>>>>:\n" + e);
    }
    // 用户/请求信息
    sysAppLog.setUserId(Integer.valueOf(MQ_LOG_USER_ID_DEFAULT));
    sysAppLog.setUserName(MQ_LOG_USER_NAME_DEFAULT);
    sysAppLog.setReqId(MQ_LOG_REQ_ID_DEFAULT);
    sysAppLog.setToken(MQ_LOG_TOKEN_DEFAULT);
    sysAppLog.setUri(MQ_LOG_URI_DEFAULT);
    sysAppLog.setCreateTime(DateUtils.toStr());
    sysAppLogMapper.insert(sysAppLog);
  }
}
```

