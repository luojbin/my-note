package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import bean.Stock;

public class ActionServlet 
	extends HttpServlet{

	@Override
	public void service(
			HttpServletRequest request, 
			HttpServletResponse response)
				throws ServletException,
					IOException {
		String uri = 
				request.getRequestURI();
		String action = 
			uri.substring(
			uri.lastIndexOf("/"),
			uri.lastIndexOf("."));
		System.out.println("action:" + action);
		response.setContentType(
				"text/html;charset=utf-8");
		PrintWriter out = 
				response.getWriter();
		if("/quoto".equals(action)){
			//模拟生成几只股票的信息
			//(会以json字符串的形式返回)
			List<Stock> stocks = 
					new ArrayList<Stock>();
			Random r = new Random();
			for(int i = 0;i < 8; i++){
				Stock s = new Stock();
				s.setCode("60087" + r.nextInt(10));
				s.setName("中国嘉陵" + r.nextInt(100));
				s.setPrice(r.nextInt(1000));
				stocks.add(s);
			}
			ObjectMapper om = 
					new ObjectMapper();
			String jsonStr = 
					om.writeValueAsString(
							stocks);
			System.out.println(jsonStr);
			out.println(jsonStr);
		}
	}
	
	
}



