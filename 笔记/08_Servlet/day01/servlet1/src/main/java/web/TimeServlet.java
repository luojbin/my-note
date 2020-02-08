package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TimeServlet extends HttpServlet {

	@Override
	protected void service(
		HttpServletRequest req, 
		HttpServletResponse res) throws ServletException, IOException {
		//获取服务器的时间
		Date date = new Date();
		SimpleDateFormat sdf =
			new SimpleDateFormat("HH:mm:ss");
		String now = sdf.format(date);
		//将时间拼到一个网页里给浏览器返回
		//告诉浏览器向它发送的是什么类型的内容
		res.setContentType("text/html");
		//获取输出流,该流指向的目标是浏览器
		PrintWriter w = res.getWriter();
		//此处偷懒,拼一个简化版的网页
		w.println("<p>" + now + "</p>");
		//关闭输出流
		w.close();
	}

}





