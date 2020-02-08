## (4)编程步骤
	step1. 获得ajax对象
		比如   var xhr = getXhr();
	step2. 调用ajax对象的方法，发送请求
		方式一 get请求
		xhr.open('get','check.do?adminCode=king',true);
		xhr.onreadystatechange = f1;
		xhr.send(null);
		注:
			true: 异步 (浏览器不会销毁当前页面，用户仍然可以
					对当前页面做其它操作)
			false:同步 (浏览器不会销毁当前页面,但是会锁定当前
					页面，用户不能够对当前页面做任何操作)。
		
		方式二 post请求
		xhr.open('post','check.do',true);
		xhr.setRequestHeader('content-type',
			'application/x-www-form-urlencoded');
		xhr.onreadystatechange = f1;	
		xhr.send('adminCode=king');
		注(了解)：
			按照http协议要求，如果发送的是post请求，应该包含有
			content-type消息头，但是，ajax默认不会带这个消息头，
			所以，需要调用setRequestHeader方法来添加这个消息头。


	step3. 编写服务器端的程序
		注：不需要返回完整的页面，只需要返回部分数据。
	step4. 编写事件处理函数
		if(xhr.readyState == 4 && 
			xhr.status == 200){
			//ajax对象已经获得了服务器返回的所有数据，
			//而且服务器处理正确。
			var txt = xhr.responseText;
			页面更新...
		}

# 1. 编码问题
## (1)get请求
	1)为什么会有乱码?
	ie浏览器提供的ajax对象，在发送get请求时，会对中文参数
	值使用"gbk"来编码，其它浏览器会使用"utf-8"来编码。服务器
	端默认会使用"iso-8859-1"来解码。所以会有乱码。
	2)如何解决?
		step1. 服务器端，统一使用"utf-8"来解码。
		可以修改
			<Connector URIEncoding="utf-8" />
		step2.客户端，使用encodeURI函数对中文参数值进行编码。
		注：
			encodeURI函数是javascript内置的函数，会使用"utf-8"
			来编码。
		  
## (2)post请求	
	1)为什么会有乱码?
	浏览器提供的ajax对象在发送post请求时，对中文参数值会使用
	"utf-8"来编码，而服务器端会使用"iso-8859-1"来解码。
	2)如何解决?
		request.setCharacterEncoding("utf-8")


# 2. 缓存问题
## (1)什么是缓存问题?
	如果使用ie浏览器提供的ajax对象发送get请求，会比较请求地址
	是否访问过，如果访问过，则不再发送新的请求，而是将第一次访问
	的结果显示出来（也就是说，第一次访问时，会将服务器返回的结果
	缓存下来了）。
## (2)如何解决?
	在请求地址后面添加一个随机数。

# 3. json (javascript object notation)  
## (1)json是什么?
	是一种轻量级的数据交换格式。
	注：json借鉴了javascript的部分语法	
	注：
		数据交换:指的是将要交换的数据转换成一种与平台无关的
			数据格式（比如xml）,然后发送给接收方来处理。
		轻量级：json相对于xml而言，文档更小，解析速度更快。
## (2)语法
	1)表示一个对象
	{属性名：属性值,属性值:属性值...}	
	注意：
		a.属性名必须使用双引号括起来。
		b.属性值可以string,number,true/false,null,object。
		c.属性值如果是string,必须使用双引号括起来。
	2)表示对象组成的数组
	[{},{},{}...]

## (3)使用json   
	1)java对象如何转换成json字符串?
		使用jackson提供的api(ObjectMapper)。
	2)将json字符串转换成javascript对象?
		使用javascript内置对象JSON提供的parse()函数。
![](json.png)		
 		
			

		

	