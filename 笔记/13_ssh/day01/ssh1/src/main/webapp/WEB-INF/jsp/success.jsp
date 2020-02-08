<%@ page language="java" 
	contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<h1>表单结果</h1>
	<p>收到了两个bean对象: message, userValue</p>
	<p>消息: ${message}</p> 
	<p>用户名: ${userValue.name}</p>
	<p>密码: ${userValue.password}</p>
	<p>年龄: ${userValue.age}</p>
	<p>地址: ${userValue.address}</p>
	<p>Session: ${loginUser} </p>
</body>
</html>








