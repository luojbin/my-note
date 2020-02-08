package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegServlet extends HttpServlet {

	@Override
	protected void service(
		HttpServletRequest req, 
		HttpServletResponse res) throws ServletException, IOException {
		//采用方案三解决POST请求乱码问题
		req.setCharacterEncoding("utf-8");
		//处理请求的一般流程
		//1.接收参数
		String name = req.getParameter("username");
		String pwd = req.getParameter("pwd");
		String sex = req.getParameter("sex");
		String[] interests = 
			req.getParameterValues("interest");
		
		//采用方案一解决乱码问题
		//byte[] bs = name.getBytes("iso8859-1");
		//name = new String(bs,"utf-8");
		
		//2.处理业务
		System.out.println(name);
		System.out.println(pwd);
		System.out.println(sex);
		if(interests != null) {
			for(String interest : interests) {
				System.out.println(interest);
			}
		}
		//3.发送响应
		res.setContentType(
			"text/html;charset=utf-8");
		PrintWriter w = res.getWriter();
		w.println("<p>ok,"+name+"</p>");
		w.close();
	}

}








