package web;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DemoServlet extends HttpServlet {

	public DemoServlet() {
		System.out.println("实例化DemoServlet");
	}

	@Override
	public void destroy() {
		super.destroy();
		System.out.println("销毁DemoServlet");
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		System.out.println("初始化DemoServlet");
	}

	@Override
	protected void service(
		HttpServletRequest req, 
		HttpServletResponse res) throws ServletException, IOException {
		System.out.println("调用DemoServlet");
	}
	
	
	
}









