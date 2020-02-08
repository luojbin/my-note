<%@page pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="/lhh-tags" prefix="s"%>
<!doctype html>
<html>
	<head>
		<meta charset="utf-8"/>
		<title>查询学生</title>
	</head>
	<body>
		<!-- 2.JSTL标签 -->
		<!-- 2.1 if标签 -->
		<p>
			性别:
			<c:if test="${stu.sex=='M' }">男</c:if>
			<c:if test="${stu.sex=='F' }">女</c:if>
		</p>
		<!-- 2.2 choose标签 -->
		<p>
			性别:
			<c:choose>
				<c:when test="${stu.sex=='M' }">男</c:when>
				<c:otherwise>女</c:otherwise>
			</c:choose>
		</p>
		<!-- 2.3 forEach标签 -->
		<p>
			<c:forEach items="${stu.interests }" var="i">
				${i }
			</c:forEach>
		</p>
		<!-- 2.4 自定义标签 -->
		<p><s:sysdate format="yyyy-MM-dd"/></p>
	
		<!-- 1.EL表达式 -->
		<!-- 1.1访问Bean的属性 -->
		<!-- request.getAttribute("stu").getName() -->
		<p>姓名:${stu.name }</p>
		<p>年龄:${stu['age'] }</p>
		<p>课程:${stu.course.id }</p>
		<!-- EL表达式的取值范围:
			它默认从4个隐含对象内依次取值:
			page->request->session->application
			也可以明确指定取值范围:
			如: requestScope.stu.name -->
		<p>性别:${requestScope.stu.sex }</p>
		<!-- 1.2支持运算 -->
		<p>年龄+3:${stu.age+3 }</p>
		<p>介于20-30间:${stu.age>20 && stu.age<30 }</p>
		<p>是否为空:${empty stu.interests }</p>
		<!-- 1.3获取请求参数 -->
		<p>参数:${param.user }</p>
	</body>
</html>








