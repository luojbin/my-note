# █ 需要的功能

- 模板管理
- 模板 + 业务数据的合成业务合同
- 业务合同下载



- 印章管理
- 业务合同盖章
- 业务合同下载


# 一. 部署 CFCA 签章系统

## 1. 数据库

MySQL5.6，设置字符集为utf8(mb4)，排序方式(Collation)大小写敏感(utfmb4_bin)，表名忽略大小写

创建数据库, 执行sql 脚本进行数据库初始化

## 2. 安装部署

1. 复制 war 包到 tomcat 下: 包括 PaperlessManager, paperlessServer, Proxy

2. 修改 tomcat 的使用端口

3. 修改配置文件

   1. jdbc.propoties

      修改数据库连接参数, 指定数据库地址和账号密码

   2. raCert.ini

      修改proxy 服务器地址为当前 tomcat 的地址 http://localhost:8092/Proxy/CertProcessor

      修改 certDN.ou1 为客户名

   3. sys.ini

      修改 paperlessServerConfig 的 sys.ini, 

      其中的图片存放路径为 tomcat/temp ( /usr/local/tomcat-cfca/bin/resources )

4. 上传配置文件到 tomcat/bin 目录下, 包括PaperlessManagerConfig, paperlessServerConfig, ProxyConfig

5. 在 tombin/bin 目录下创建图片资源目录 resources ( 与3.3 中 sys.ini 的设置匹配)

6. 安装字体, 上传字体文件到 $JAVA_HOME/jre/lib/fonts/fallback,(宋体, 仿宋, 黑体, 微软雅黑, 幼圆, 楷体, 隶书)

7. 启动 tomcat 

# 二. CFCA 签章数据

## 1. 签章数据

合同中每一个印迹( 印模盖章留下的痕迹 ), 都包括印模信息( 印章所有者的信息) , 盖章的场景信息(多媒体数据), 以及印迹的位置信息: 

### 1) 印模信息

| 字段名     | 字段含义                             | 字段类型                             |
| ---------- | ------------------------------------ | ------------------------------------ |
| signType   | 签章类型, 个人 或 企业               | SignType                             |
| identityNo | 营业执照号或身份证号                 | String                               |
| phoneNo    | 手机号                               | String                               |
| email      | 邮箱                                 | String                               |
| fullName   | 全名                                 | String                               |
| imagFile   | 签章图片                             | File                                 |
| localtions | 页面签章位置(可以有多个位置)         | List<ContractChapterEntity.Location> |
| sealCode   | 签章编号, 在cfca系统中创建的印模编号 | String                               |

### 2) 场景信息

**multiData**: 签章场景证据文件(多媒体数据), String ( json 格式的文件数据列表 )

### 3) 位置信息

其中的页面签章位置 location, 由页码+坐标组成, , 坐标为 印迹 在页面上的纵横坐标

又因为一个印章可以盖在合同中的多处, 用 list 封装

```java
public static class Location {
    /** 页码 */
    private int page;
    /** 坐标列表 */
    private List<Coordinates> chaptes;
```

# 三. 签章应用

## 1. 签章要求

准备好合同, 填充数据, 印模, 签章时的多媒体信息, 调用 cfca 的签章服务接口.

因为需要在合同中加入 签章场景的多媒体信息, 需要选用支持多媒体信息的接口, 即 **compoundSealAutoPdf**

## 2. 接口格式

接口文档 2.6 PDF 自动化复合签章接口

**使用场景：**主要用于对 pdf 进行合成**多媒体**、**一次性**任意签章；如果有手写签名, 同一个 pdf 不能连续多次调用，否则 pdf 会报错

```java
public byte[] compoundSealAutoPdf(
    String pdfBeanXml, 
    String multiData，
    String compoundSealStrategyXml，
    String operatorCode, 
    String channelBeanXml)throws Exception
```

### 1) 方法参数

#### 1. pdfBeanXml

```xml
<PdfBean>
    <Pdf></Pdf>
    <PdfOwnerPassword>pdf拥有者密码Base64编码</PdfOwnerPassword>
    <PdfId></PdfId>
    <InputFilePath>
        pdf地址，支持文件路径、ftp、http，Pdf为空时生效
    </InputFilePath>
    <SavedPdfId>临时保存的pdfId，可以为空</SavedPdfId>
    <BizSerialNo>业务流水号, 可以为空</BizSerialNo>
    <BizTypeCode>业务类型编码(用来分类pdf), 可以为空</BizTypeCode>
    <CardNo>卡号, 可以为空</CardNo>
    <OutputFilePath>单据存放地址，可以为空</OutputFilePath>
    <ReturnPdfOrNot>是否返回pdf，默认为true</ReturnPdfOrNot>
    取值false时，OutputFilePath不能为空
    <Reserved1>保留字段1, 可以为空</Reserved1>
    <Reserved2>保留字段2, 可以为空</Reserved2>
    <Reserved3>保留字段3, 可以为空</Reserved3>
</PdfBean>
```

Pdf参数说明：

如果 pdf 的字节长度大于18小于32并且为数字时，按文件 pdfId 处理（之前保存的 savedPdfId，需要从临时 pdf 文件表中获取 pdf 数据）；

如果pdf的字节长度小于500且不为数字时，按照文件路径格式处理（“/cfca/1.pdf”或者“D:/cfca/1.pdf”或者“./cfca/1.pdf”）

OutputFilePath：可以是如下格式：

1. 文件路径：/home/22.pdf
2. ftp地址：ftp:/home/2015/201505/20150501/1.pdf或者sftp:/home…
3. 无纸化系统自动创建，格式为ftp:auto;auto，无纸化系统会根据fileStoreMainDirectory||channelCode||bizTypeCode||operatorCode||yyyy||yyyyMM||yyyyMMdd的任意组合创建目录（注意，如果柜员编码或机构号传入多个，创建路径时会选择最后一个柜员编号或机构号）

#### 2. multiData

需要合成到pdf的多媒体数据，格式同上, 可以为空

#### 3. compoundSealStrategyXml

复合证书签章策略文件，格式如下：

```xml
<List>证据证书签章策略文件1、2、3 签章策略文件1、2、3 </List>
```

#### 4. operatorCode

柜员编码或机构号，可多个，格式：operatorCode##operatorCode##

#### 5. channelBeanXml

渠道信息，可以为空

```xml
<Channel>
    <ChannelCode>渠道编码</ChannelCode>
    <MerchantNo>商户号，可以为空</MerchantNo>
    <MerchantName>商户名称，可以为空</MerchantName>
    <TerminalNo>终端号，可以为空</TerminalNo>
</Channel>
```

### 2) 返回结果

**正常返回：**

盖章后的pdf文件

或者返回如下字符串的utf-8字节编码

（ReturnPdfOrNot为false并且OutputFilePath不为空时）

```xml
<Result>
    <Code>200</Code>
    <Message>successfully!</Message>
</Result>
```

**异常返回：**

```xml
<Error>
    <ErrorCode >errorCode</ErrorCode >
    <ErrorMessage>errorMessage</ErrorMessage>
</Error>
```

**抛出：**

`Exception`

## 3. 准备数据



# 一. 自动化合成模板业务数据接口

```java
public byte[] synthesizeAutoTemplate(
    String templateCode, 
    String savedPdfId,	// 可选参数, 有此项为空的重载方法
    String fieldBeanListXml，
    String textBeanListXml, 
    String imageBeanListXml, 
    String operatorCode,
    String channelCode
    ) throws Exception
```

**使用场景：**合成业务数据到模板生成单据，业务数据包括文本、图片

## 方法参数

### 1. templateCode

模板号，支持传入多个模版号时返回合并后的pdf，比如：“tmp001,tmp002”

### 2. savedPdfId

保存到临时表中的pdfId，符合唯一约束，可为空, 有此项为空的重载方法

### 3. fieldBeanListXml

需要合成到pdf文本域的业务数据，可为空，有两种格式，

第一种格式如下：

```xml
<FieldList hashAlg="sha1" savedBizXmlId="" savedTimeIncrement="" partialFlattening="true/false">
    <Field>
        <FieldId></FieldId>必填
        <FieldName></FieldName>字段名称，可为空
        <FieldValue></FieldValue>可以为空
        <FieldType></FieldType> FieldType：text,checkbox
        <FieldValueHash></FieldValueHash>可为空
        <TemplateIndex></TemplateIndex>
        // 模板序号，取值：1、2、3…，不为空且不为0时合成到指定模板号，
        // 为空或0时所有字段合成到所有模板，此字段只适应此方法
    </Field>
</FieldList>
```

第二种格式：bizXmlId，即之前保存的 savedBizXmlId

 1. savedBizXmlId：报文保存的**ID**，下同

 2. savedTimeIncrement：报文保存的时间增量（分钟），不可以是负数，下同

 3. partialFlattening：默认是**false**，设置为**true**时表示没有传值的文本域会被保留，可以第二次合成，目前支持一个模板。

### 4. textBeanListXml 

需要合成到pdf内容中的业务数据，可为空，有两种格式，

第一种格式如下：

```xml
<TextList hashAlg="sha1" savedBizXmlId="" savedTimeIncrement="">
    <Text>
        <TextValue></TextValue>必填
        <TextValueHash></TextValueHash>可为空
        <TextFontSize></TextFontSize>字体大小，比如：10、11、12像素
        <TextColor></TextFontSize>FFFFFF、000000
        <Type></Type>类型，2：坐标；3：关键字，必填
        <PageNo>1</PageNo>页码，必填
        <LX></LX>必填（单位：像素）
        <LY></LY>必填（单位：像素）
        <Keyword></Keyword>关键字，必填
        <LocationStyle></LocationStyle>关键字风格，C、U、D、L、R,必填
        <OffsetX></OffsetX>X轴偏移量（单位：像素），可为空
        <OffsetY></OffsetY>X轴偏移量（单位：像素），可为空
        <TemplateIndex></TemplateIndex>//模板序号，同上
    </Text>
</TextList>
```

第二种格式：bizXmlId，即之前保存的savedBizXmlId

### 5. imageBeanListXml

需要合成到pdf的图片数据，可为空，有两种格式，第一种格式如下：

```xml
<ImageList hashAlg="sha1" savedBizXmlId="" savedTimeIncrement="">
    <Image>可以没有该节点
        <ImageValue></ImageValue>图片内容base64编码，可为空
        <SealImageCode></SealImageCode>图片为空时用，可为空
        <ImagePath></ImagePath>当图片和印模编码都为空时使用，可为空
        有如下两种情况：
        图片全路径的Base64编码
        图片名称的Base64编码（需要根据sys.ini中的imageResourcePath参数组成图片全路径）
        <ImageWidth></ImageWidth >图片宽度，必填
        <ImageHeight></ImageHeight>图片高度，必填
        <ImageHash></ImageHash >可为空
        <Type></Type>类型，2：坐标；3：关键字，必填
        <PageNo>1</PageNo>页码，必填
        <LX>100</LX>必填
        <LY>100</LY>必填
        <Keyword></Keyword>关键字，必填
        <LocationStyle></LocationStyle>关键字风格，C、U、D、L、R,必填
        <OffsetX></OffsetX>X轴偏移量（单位：像素），可为空
        <OffsetY></OffsetY>X轴偏移量（单位：像素），可为空
        <TemplateIndex></TemplateIndex>//模板序号，同上
    </Image>
    <QRCodeXml>可为空，也可以是多个
        <QRCodeContent></ QRCodeContent>二维码内容，必填
        <Width></Width>二维码宽度默认（单位：像素），必填
        <Height></Height>二维码高度默认（单位：像素），必填
        <PageNo>1</PageNo> 页码，必填
        <LX></LX>二维码存放在pdf中的位置（单位：像素），必填
        <LY></LY>二维码存放在pdf中的位置（单位：像素），必填
        <TemplateIndex> </TemplateIndex>//模板序号，同上
    </QRCodeXml>
</ImageList>
```

​       第二种格式：bizXmlId，即之前保存的savedBizXmlId

### 6. operatorCode

操作员编码或者机构号

### 7. channelCode

渠道编码，可以为空

## 返回结果

**正常返回：**

合成后的pdf文件

**异常返回：**

```xml
<Error>
    <ErrorCode>errorCode</ErrorCode>
    <ErrorMessage>errorMessage</ErrorMessage>
</Error>
```

**抛出：**

`Exception`

# 二. PDF 自动化合成业务数据接口

```java
public byte[] synthesizeAutoBusinessPdf(
    byte[] pdf, 
    String savedPdfId,
    String fieldBeanListXml，
    String textBeanListXml, 
    String imageBeanListXml, 
    String operatorCode,
    String channelCode
    )throws Exception
```

**使用场景：**合成业务数据到pdf中，业务数据包括文本域、文本和图片

**入参：**

pdf：pdf 文件数据( IoUtil 从客户端读取) 或 cfca服务器端文件路径, 或者是pdfId（pdfId表示之前保存的savedPdfId

savedPdfId：临时保存的pdfId，可以为空

fieldBeanListXml：需要合成到pdf文本域的业务数据或者是bizXmlId（同上），可为空

textBeanListXml：需要合成到pdf内容中的业务数据或者是bizXmlId（同上），可为空

imageBeanListXml：图片列表或者是bizXmlId（同上），可为空

operatorCode：操作员编码或者机构号

channelCode：渠道编码，可以为空

# 三. PDF自动化签章接口

```java
public byte[] sealAutoPdf(
    byte[] pdf, 
    String savedPdfId,
    String sealStrategyXml，
    String operatorCode, 
    String channelCode
    ) throwsException
```

**使用场景：**`自动化普通签章（印模图片可以外部传入）```

**入参：**

pdf：pdf文件数据或者是pdfId（pdfId表示之前保存的savedPdfId）或文件路径

savedPdfId：临时保存的pdfId

sealStrategyXml：签章策略文件，见附件

operatorCode：操作员编码或者机构号

channelCode：渠道编码，可以为空

**正常返回：**

盖章后的pdf文件

**异常返回：**

```xml
<Error>
    <ErrorCode>errorCode</ErrorCode>
    <ErrorMessage>errorMessage</ErrorMessage>
</Error>
```

**抛出：**

`Exception`

# 四. 自动化复合签章接口

```java
public byte[] compoundSealAutoPdf(
    String pdfBeanXml, 
    String multiData，
    String compoundSealStrategyXml，
    String operatorCode, 
    String channelBeanXml)throws Exception
```

**使用场景：**主要用于对 pdf 进行合成多媒体、一次性任意签章；如果有手写签名, 同一个 pdf 不能连续多次调用，否则 pdf 会报错

**入参：**

## 方法参数

### 1. pdfBeanXml：格式如下：（下同）

```xml
<PdfBean>
    <Pdf></Pdf>
    <PdfOwnerPassword>pdf拥有者密码Base64编码</PdfOwnerPassword>
    <PdfId></PdfId>
    <InputFilePath>
        pdf地址，支持文件路径、ftp、http，Pdf为空时生效
    </InputFilePath>
    <SavedPdfId>临时保存的pdfId，可以为空</SavedPdfId>
    <BizSerialNo>业务流水号, 可以为空</BizSerialNo>
    <BizTypeCode>业务类型编码(用来分类pdf), 可以为空</BizTypeCode>
    <CardNo>卡号, 可以为空</CardNo>
    <OutputFilePath>单据存放地址，可以为空</OutputFilePath>
    <ReturnPdfOrNot>是否返回pdf，默认为true</ReturnPdfOrNot>
    取值false时，OutputFilePath不能为空
    <Reserved1>保留字段1, 可以为空</Reserved1>
    <Reserved2>保留字段2, 可以为空</Reserved2>
    <Reserved3>保留字段3, 可以为空</Reserved3>
</PdfBean>
```

Pdf参数说明：

如果 pdf 的字节长度大于18小于32并且为数字时，按文件 pdfId 处理（之前保存的 savedPdfId，需要从临时 pdf 文件表中获取 pdf 数据）；

如果pdf的字节长度小于500且不为数字时，按照文件路径格式处理（“/cfca/1.pdf”或者“D:/cfca/1.pdf”或者“./cfca/1.pdf”）

OutputFilePath：可以是如下格式：

1. 文件路径：/home/22.pdf
2. ftp地址：ftp:/home/2015/201505/20150501/1.pdf或者sftp:/home…
3. 无纸化系统自动创建，格式为ftp:auto;auto，无纸化系统会根据fileStoreMainDirectory||channelCode||bizTypeCode||operatorCode||yyyy||yyyyMM||yyyyMMdd的任意组合创建目录（注意，如果柜员编码或机构号传入多个，创建路径时会选择最后一个柜员编号或机构号）

### 2. multiData: 需要合成到pdf的多媒体数据，格式同上, 可以为空

### 3. compoundSealStrategyXml：

复合证书签章策略文件，格式如下：

```xml
<List>证据证书签章策略文件1、2、3 签章策略文件1、2、3 </List>
```

### 4. operatorCode

柜员编码或机构号，可多个，格式：operatorCode##operatorCode##

### 5. channelBeanXml

渠道信息，可以为空

```xml
<Channel>
    <ChannelCode>渠道编码</ChannelCode>
    <MerchantNo>商户号，可以为空</MerchantNo>
    <MerchantName>商户名称，可以为空</MerchantName>
    <TerminalNo>终端号，可以为空</TerminalNo>
</Channel>
```

## 返回结果

**正常返回：**

盖章后的pdf文件

或者返回如下字符串的utf-8字节编码

（ReturnPdfOrNot为false并且OutputFilePath不为空时）

```xml
<Result>
    <Code>200</Code>
    <Message>successfully!</Message>
</Result>
```

**异常返回：**

```xml
<Error>
    <ErrorCode >errorCode</ErrorCode >
    <ErrorMessage>errorMessage</ErrorMessage>
</Error>
```

**抛出：**

`Exception`