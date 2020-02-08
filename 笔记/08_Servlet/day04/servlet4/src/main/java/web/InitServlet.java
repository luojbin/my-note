package web;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

/**
 * 此类仅仅是在服务器启动时初始化参数的,
 * 不负责处理任何具体的请求.
 */
public class InitServlet extends HttpServlet {

	@Override
	public void init() throws ServletException {
		super.init();
		ServletContext ctx = 
			getServletContext();
		ctx.setAttribute("count", 0);
	}

}






