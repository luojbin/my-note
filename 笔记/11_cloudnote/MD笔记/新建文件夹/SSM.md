# SSM 整合应用

# 一. 创建项目
1. 创建项目
2. 导包
3. 导入 spring-mvc.xml
4. 编辑 web.xml

## 注解 ResponseBody
Responsebody 会自动将返回结果中 JavaBean 转换为 JSON 字符串发送到浏览器客户端.
可以返回各种满足 JavaBean 规范的对象, 可以是自定义的, 也可以是List, Map 等等
利用Json返回的时候, 和用javaBean
底层用了 Jackson API

	@Controller
	@RequestMapping("/demo")
	public class DemoController {
		@RequestMapping("/ary.do")
		@ResponseBody
		//Responsebody 会自动将返回结果中 JavaBean 转换为 JSON 字符串发送到浏览器客户端.
		//底层用了 Jackson API
		public Object test(){
			String[] ary = {"李洪鹤","刘苍松","王克晶","范传奇","程祖红"};
			return ary;
		}
	}

## 创建 JavaBean
### 要求
实现序列化接口
无参构造器
get/set方法

	@RequestMapping("/admin.do")
	@ResponseBody
	//将 JavaBean 作为返回值, ResponseBody 注解将 Bean 转换为 JSON 字符串发送到浏览器端
	public Object test2(){
		Admin a = new Admin();
		a.setName("ssss");
		a.setAge(20);
		a.setAddr("beijing");
		return a;
	}

### 常见错误
406
javaBean 定义不规范
或 jackson 包未导入

# JSON
是 JavaScript 中声明对象的直接量
JSON 对象就是 JavaScript 对象

# JSON 字符串
符合 JSON 语法的字符串

# 如何将字符串转换成对象

> var str = '{"属性1":"值1","属性2":"值2"}';
> var obj = eval("("+str+")");

day11 上午2:43
