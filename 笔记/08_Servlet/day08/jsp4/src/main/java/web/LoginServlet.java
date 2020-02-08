package web;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

	//模拟MainServlet.login()
	@Override
	protected void service(
		HttpServletRequest req, 
		HttpServletResponse res) throws ServletException, IOException {
		String user = req.getParameter("user");
		//将账号存入cookie
		//cookie中只能存一条数据,
		//并且只能存字符串.
		Cookie c1 = new Cookie("user",user);
		//将cookie存到硬盘上
		c1.setMaxAge(60*30);
		//将cookie绑定到response上,
		//当服务器发送响应时会自动发送cookie.
		res.addCookie(c1);
		
		//再创建一个cookie,存入中文
		Cookie c2 = new Cookie(
			"city",URLEncoder.encode("北京", "utf-8"));
		res.addCookie(c2);
		
		//再创建一个cookie,设置其有效路径
		Cookie c3 = new Cookie("status","1");
		c3.setPath("/jsp4");
		res.addCookie(c3);
		
	}

	
	
	
}







