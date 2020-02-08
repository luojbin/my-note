# 1.jQuery对ajax编程的支持
## (1)$.ajax方法
	1)用法:
		$.ajax({});
	注：{}是一个对象，其属性用来控制ajax对象如何向服务器
		发送请求，常见的属性如下。
		url: 请求地址
		type: 请求类型
		data: 请求参数(可以是请求字符串形式，比如
			"adminCode=king&age=22",
			还可以是对象形式，比如{"adminCode":"king","age":22})
		dataType: 服务器返回的数据类型,有如下类型：
				"json"    json字符串
				"text"    文本
				"html"    html文档
				"xml"     xml文档
				"script"  javascript脚本
		success: 绑订事件处理函数(服务器已经返回了所有数据，
				并且没有出错)。
		error: 绑订事件处理函数（服务器出错了）
	比如:
		$.ajax({
			"url":"check.do",
			"type":"get",
			"data": "adminCode=king",
			"dataType":"text",
			"success": function(obj){
						 //处理服务器返回的数据了
						 obj就是服务器端返回的数据。
						 如果返回的是json字符串，会
						 自动转换成javascript对象。	
					   }，
			"error": function(){
					}			
		});
	
## (2) load方法
	1)该方法会向服务器发送异步请求，并且将服务器返回的数据
	直接添加到符合要求的节点之上。
	2)用法
		$obj.load(url,[data]);
		url : 是请求地址。
		data: 是请求参数。有两种写法（请求字符串和对象的形式）
		注: $obj,是jQuery对象
			