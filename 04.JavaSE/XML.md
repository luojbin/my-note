# XML 

## 1. 概述

### 1.1. XML 概述

可扩展标记语言
能够表示层次结构, 且重复的元素不会被曲解
与 HTML 类似, 都源于古老的"标准通用标记语言 SGML"

特点:

- 大小写敏感
- 必须有结束标记, 结束标签或结束标记
- 属性值必须用引号括起来
- 所有属性都必须有属性值

### 1.2. XML 的结构

- 文档头: 声明文件版本以及采用的编码方式, 可选, 但建议使用

  `<?xml version="1.0" encoding="utf-8">`

- 文档类型定义: DTD, 用来规定文档结构, 确保文档正确的一种机制

- 根元素: 有且只有一个根元素, 包含其他的元素

  - 元素: 用 XML 标签确定的最小单元, 有单标签元素和双标签元素
  - 属性: 写在元素标签内, 用来描述元素的属性
  - 内容: 写在双标签元素的两个标签之间的东西, 可以是纯文本, 也可以是子元素, 通常是元素要描述的客体, 或是元素的组成部分\

- 混合式内容
  如果一个元素, 既有子元素, 又有文本内容, 则会为解析带来麻烦, 容易造成错误.
  在设计 XML 文档结构时, 最好时元素要么只包含子元素, 要么只包含文本, 应尽量避免混合式内容的元素.

```xml
<?xml version="1.0">
<!DOCTYPE configuration...>
<configuration>
 <title>
 ...
 </title>
</configuration>
```



#### 属性 or 子元素

用来描述一个元素时, 既可以使用元素的属性, 也可以使用元素的子元素, 但属性的灵活性不如子元素

通常, 属性应该只用来修改值的解释, 而不应用来指定值

元素和文本是 XML 文档"主要的支撑要素", 除此之外还有以下标记

- 字符引用
- 实体引用
- CDATA部分
  是字符数据的一种特殊形式, 其中的字符数据按照文本字符串来解读, 而不会被视为是标记, 可以用来囊括还有 < > & 的内容
  但其内容部分不能包括 CDATA 的结束标记, 即 `]]>`

> < ![CDATA[**具体内容**]]>



- 处理指令
  为了在处理 XML 文件的应用程序中使用的指令, 用来限定指令的界限, 如文档头指令

> < ? 指令内容 ?>

- 注释

给文档读者提供的信息, 其中不应包含有隐藏的命令, 命令应该是用处理指令实现的.0

## 2. 解析 XML

java 库提供了两种 xml 解析器

- dom, Document Object Model, 树形解析器, 将 xml 文档转换成树结构
- sax, Simple API for XML, 流式解析器, 在读入 xml 文档时执行相应的事件

### dom

大多数情况下, dom 解析器相对简单一些, 但对于大文件, 生成树形结构可能会消耗大量内存. 

如果只关心某些元素, 而不关注上下文, 可以选用 SAX 解析器



### sax



## 3. 验证 XML

### 3.1. 文档类型定义 

### 3.2. XML Schema

### 3.3. 使用示例

## 4. 使用XPATH 来定位信息

```java
public static void main(){
	XPathFactory xpfactory = XPathFactory.newInstance();	
	XPath path = xpfactory.newXPath();
    String data = path.evaluate("xx/yy/zz", doc);
}
```

## 5. 使用命名空间

## 6. 流机制解析器

### 6.1. 使用 SAX 解析器

### 6.2. 使用 StAX 解析器 

## 7. 生成 XML 文档

### 7.1. 不带命名空间的文档

### 7.2. 带命名空间的文档

### 7.3. 写出文档

### 7.4. 示例: 生成 SVG 文件

### 7.5. 使用 StAX 写 XML 文档

## 8. XSL 转换

# dom4j

## api结构

### Element

每一个实例表示XML文档中的一个元素(一对标签), 提供了获取该元素相关信息读写方法:

#### 写方法

| 方法名                  | 返回值  | 描述                                                         |
| ----------------------- | ------- | ------------------------------------------------------------ |
| addElement(String name) | Element | 向当前元素中追加给定名字的子元素，并 以Element实例将其返回，便于继续操作 |
|                         |         |                                                              |
|                         |         |                                                              |
|                         |         |                                                              |
|                         |         |                                                              |
|                         |         |                                                              |
|                         |         |                                                              |



#### 读方法

| 方法                     | 返回类型 | 描述                           |
| ------------------------ | -------- | ------------------------------ |
| `getName()`              |          | 获取当前标签的名字             |
| `element(String name)`   |          | 获取当前标签中指定名字的子标签 |
| `elements()`             |          | 获取当前标签中的所有子标签     |
| `elements(String name)`  |          | 获取当前标签中所有同名子标签   |
| `attribute(String name)` |          | 获取当前标签中指定名字的属性   |
| `getText()`              |          | 获取当前标签中间的文本数据     |

### Attribute

Attribute的每一个实例用于表示一个属性

- `getName()`
- `getValue()`

## 写出xml

写出XML文档的大致步骤:

1. 创建`Document`对象表示一个空白文档
2. 向`Document`中添加根元素
3. 按照XML设计的结构向根元素中 逐级添加子元素及数据
4. 创建`XMLWriter`
5. 使用`XMLWriter`将`Document`对象写出, 以生成XML文档

```java
public static void main(String[] args) {
    try {
        List<Emp> empList = new ArrayList<Emp>();
        empList.add(new Emp(1,"张三",22,"男",3000));
        empList.add(new Emp(2,"李四",23,"女",4000));
        empList.add(new Emp(3,"王五",24,"男",5000));
        empList.add(new Emp(4,"赵六",25,"女",6000));
        empList.add(new Emp(5,"钱七",26,"男",7000));

        // 创建文档, 添加根元素
        Document document = DocumentHelper.createDocument();
        Element root = document.addElement("list");

        for(Emp emp : empList){
            Element empEle = root.addElement("emp");
            // 添加子节点及内容
            empEle.addElement("name").addText(emp.getName());
            empEle.addElement("age").addText(emp.getAge()+"");
            empEle.addElement("gender").addText(emp.getGender());
            empEle.addElement("salary").addText(emp.getSalary()+"");

            // 添加属性
            empEle.addAttribute("id", emp.getId()+"");	
        }
        // 创建 writer
        XMLWriter writer = new XMLWriter(
            new FileOutputStream("myemp.xml"),
            OutputFormat.createPrettyPrint()
        );
        // 写出xml
        writer.write(document);
        System.out.println("写出完毕!");
        writer.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
}
```

## 解析xml

解析XML的大致步骤:

1. 创建`SAXReader`
2. 读取要解析的XML文档并生成 `Document`对象, 需要将XML文档都读取完毕并载入内存, 耗时耗资源的环节
3. 通过`Document`对象获取根元素`Element`对象
4. 按照XML文档的结构从根元素开始 逐级获取子元素以达到遍历XML文档 数据的目的

```java
public static void main(String[] args) {
    try {
        SAXReader reader = new SAXReader();
        Document document = reader.read(new File("emplist.xml"));
        Element root = document.getRootElement();

        // 创建一个集合用于保存所有从 XML文档中解析的员工信息
        List<Emp> empList = new ArrayList<Emp>();

        // 获取根标签<list>中的所有<emp>标签
        List<Element> list = root.elements();
        for(Element empEle : list){
            // System.out.println(empEle.getName());

            //获取员工姓名
            Element nameEle = empEle.element("name");
            String name = nameEle.getText();
            System.out.println(name);

            Element ageEle = empEle.element("age");
            int age = Integer.parseInt(ageEle.getText());
            String gender = empEle.elementText("gender");
            int salary = Integer.parseInt(empEle.elementText("salary"));
			
            // 属性操作
            Attribute attr = empEle.attribute("id");
            int id = Integer.parseInt(attr.getValue());

            Emp emp = new Emp(id, name, age, gender, salary);
            empList.add(emp);
        }
        for(Emp e : empList){
            System.out.println(e);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}
```

