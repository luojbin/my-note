<%@ page contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
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
	<h2>ValueStack</h2>
	<s:debug></s:debug>
	<h2>利用OGNL表的式读取ValueStack中的数据</h2>
	<p>读取ValueStack中的Action对象的数据</p>
	<s:property value="products[0].name"/> 
	<h3>利用ValueStack 和 OGNL 显示商品列表</h3>
	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>名称</th>
				<th>价格</th>
				<th>描述</th>
			</tr>
		</thead>
		<tbody>
			<s:iterator value="products" var="p">
				<tr>
					<td><s:property value="id"/></td>
					<td><s:property value="name"/></td>
					<td><s:property value="price"/></td>
					<td><s:property value="description"/></td>
				</tr>
			</s:iterator>
		</tbody>
	</table>

</body>
</html>










