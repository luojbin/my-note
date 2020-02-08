package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IndexServlet extends HttpServlet {

	//模拟MainServlet.toIndex()
	@Override
	protected void service(
		HttpServletRequest req, 
		HttpServletResponse res) throws ServletException, IOException {
		//浏览器访问服务器时,会自动传入
		//之前保存的cookie.
		Cookie[] cookies = req.getCookies();
		if(cookies != null) {
			res.setContentType(
				"text/html;charset=utf-8");
			PrintWriter w = res.getWriter();
			for(Cookie c : cookies) {
				String value = 
					URLDecoder.decode(
					c.getValue(), "utf-8");
				w.println(
					c.getName()+":"+value);
			}
			w.close();
		}
	}

}











