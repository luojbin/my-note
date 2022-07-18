# Jersey

# 一. 概述

类似于 springmvc 的 webservice 框架, 遵循 JSR-370, 是 JAX-RS 的推荐实现

# 二. 基础

添加依赖

springboot + jersey

注册组件

可以按包注册(`packages`), 也可以按类注册(`register`)

```java
@Component
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        packages("com.luojbin.jersey.api");
    }
}
```

过滤器

拦截器

aop

