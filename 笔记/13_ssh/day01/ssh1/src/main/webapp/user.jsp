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
	<h1>提交用户信息</h1>
	<form action="demo/user.action" 
		method="post">
		<div>
			用户名:<input type="text" 
				name="userValue.name">
		</div>		
		<div>
			密码:<input type="password"
				name="userValue.password">
		</div>
		<div>
			年龄:<input type="text"
				name="userValue.age"> 
		</div>
		<div>
			地址: <input type="text"
				name="userValue.address">
		</div>
		<div>
			<input type="submit" value="保存">
 		</div>
	</form>
</body>
</html>



