package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ActionServlet 
	extends HttpServlet{

	@Override
	public void service(
			HttpServletRequest request, 
			HttpServletResponse response)
				throws ServletException,
				IOException {
		System.out.println("service()");
		//分析请求路径，依据分析结果调用不同
		//的分支来处理。
		
		// 获得请求资源路径  
		String uri = 
				request.getRequestURI();
		System.out.println("uri:" + uri);
		// 为了方便分析，截取请求资源路
		//径的一部分
		String action = 
			uri.substring(
				uri.lastIndexOf("/"),
				uri.lastIndexOf("."));
		System.out.println("action:" + action);
		request.setCharacterEncoding("utf-8");
		response.setContentType(
				"text/html;charset=utf-8");
		PrintWriter out = 
				response.getWriter();
		if("/check".equals(action)){
			String adminCode = 
				request.getParameter(
						"adminCode");
			System.out.println("adminCode:"
						+ adminCode);
			if("king".equals(adminCode)){
				out.println("帐号已经存在");
			}else{
				out.println("可以使用");
			}
		}else if("/getNumber".equals(action)){
			Random r = new Random();
			int number = 
					r.nextInt(1000);
			System.out.println("number:" + number);
			out.println(number);
		}
	}
	
	
}



