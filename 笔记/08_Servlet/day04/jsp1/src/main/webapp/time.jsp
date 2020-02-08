<!-- 
pageEncoding: 声明此jsp文件的编码
contentType: 声明此jsp向浏览器输出的内容格式
 -->
<%@page pageEncoding="utf-8"
	contentType="text/html"
	import="java.util.*,java.text.*"%>
<%
	Date d = new Date();
	SimpleDateFormat sdf = 
		new SimpleDateFormat("HH:mm:ss");
	String time = sdf.format(d);
%>
<p><%=time %></p>	
	
	
	
	
	
	
	
	
	