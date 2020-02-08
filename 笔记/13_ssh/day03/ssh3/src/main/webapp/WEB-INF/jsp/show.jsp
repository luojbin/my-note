<%@ page contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" 
	uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>ValueStack</title>
</head>
<body>
	<h1>ValueStack</h1>
	<h2>读取内容区域的值</h2>
	<s:property value="name"/>
	<s:property value="age"/>
	<s:property value="target"/>
	
	<h2>读取上下文区域的值</h2>
	<p>读取上下文区域使用#为开头的表达式</p>
	<s:property value="#request.message"/>
	<s:property value="#session.loginState"/>
	<s:property value="#application.count"/>
	
</body>
</html>













