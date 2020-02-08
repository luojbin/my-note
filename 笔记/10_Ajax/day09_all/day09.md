# 1. Spring集成MyBatis (方式二 了解)
## (1)集成步骤
	step1.导包。
	spring-webmvc,mybatis,mybatis-spring,
	dbcp,ojdbc,spring-jdbc,junit。

	step2.添加spring配置文件。
	注：不再需要MyBatis的配置文件,可以在spring的配置文件里面
	添加SqlSessionFactoryBean来代替。

	step3.实体类
	step4.映射文件
		注：namespace不再要求等于接口名。
	step5.DAO接口
		注：接口方法没有特定要求
	step6.写一个DAO接口的实现类
		注：可以注入SqlSessionTemplate。
![](st.png)	
![](st2.png)

# 2. 使用Spring集成MyBatis的方式重写AdminDAO
	step1. 导包
		需要添加 mybatis,mybatis-spring,spring-jdbc
	step2. 在配置文件当中，添加
		SqlSessionFactoryBean
	step3. 实体类Admin 
		要注意属性与表的字段名不一样，建议用别名解决
	step4. 映射文件
		AdminMapper.xml
			namespace="cn.tedu.netctoss.dao.AdminDAO"
		<select id="findByAdminCode" 
			parameterType="java.lang.String"
			resultType="cn.tedu.netctoss.entity.Admin">
			SELECT ...
		</select>
	step5. Mapper映射器 (AdminDAO)
		不用写了 
	step6. 配置MapperScannerConfigurer 
	step7. 测试 AdminDAO	


# 3. ajax (asynchronous javascript and xml 异步的javascript和xml)
## (1)ajax是什么?	
	是一种用来改善用户体验的技术，本质上是利用浏览器提供的一个
	特殊对象(XMLHttpRequest对象，一般也可以称之为ajax对象)向
	服务器发送异步请求；服务器返回部分数据，浏览器利用这些数据
	对当前页面做部分更新；整个过程，页面无刷新，不打断用户的操作。
	注：
		异步请求，指的是，当ajax对象发送请求时，浏览器不会销毁
	当前页面，用户仍然可以对当前页面做其它操作。
![](ajax.png)

## (2)如何获得ajax对象?
	function getXhr(){
		var xhr = null;
		if(window.XMLHttpRequest){
			//非ie浏览器
			xhr = new XMLHttpRequest();
		}else{
			xhr = new ActiveXObject('MicroSoft.XMLHttp');
		}
		return xhr;
	}

## (3)ajax对象的几个重要属性
	onreadystatechange: 绑订事件处理函数，用来处理readystatechange
		事件。
		注：当ajax对象的readyState属性值发生了任何的改变，比如
		从0变成了1，就会产生readystatechange事件。
	readyState：有5个值(分别是0,1,2,3,4),用来获取ajax对象与服务
		器通信的进展。其中,4表示ajax对象已经获得了服务器返回的所
		有的数据。
	responseText:获得服务器返回的文本数据。
	responseXML:获得服务器返回的xml数据。
	status:获得状态码。

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
	
	
	
				