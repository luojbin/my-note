package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FindCostServlet extends HttpServlet {

	@Override
	protected void service(
		HttpServletRequest req, 
		HttpServletResponse res) throws ServletException, IOException {
		Cookie[] cookies = req.getCookies();
		if(cookies != null) {
			res.setContentType(
				"text/html;charset=utf-8");
			PrintWriter w = res.getWriter();
			for(Cookie c : cookies) {
				w.println(
					c.getName()+":"+c.getValue());
			}
			w.close();
		}
	}

}





