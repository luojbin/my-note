<%@ page contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" 
	uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>产品管理</title>
<style type="text/css">
table {
	border-collapse: collapse;
}
td, th{
	padding: 5px 10px; 
}
th{
	border-bottom: 2px solid #ddd;
}
td{
	border-top: 1px solid #ccc;
}
</style>
</head>
<body>
	<h1>产品管理</h1>
	<table>
		<thead>
			<tr>
				<th>编号</th>
				<th>名称</th>
				<th>价格</th>
				<th>描述</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${products}" var="p">
				<tr>
					<td>${p.id}</td>
					<td>${p.name}</td>
					<td>${p.price}</td>
					<td>${p.description}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
</body>
</html>










