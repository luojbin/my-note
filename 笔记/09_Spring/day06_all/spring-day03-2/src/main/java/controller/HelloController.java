package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sun.xml.internal.ws.handler.HandlerException;

@Controller
public class HelloController {
	@ExceptionHandler
	/**
	 * 这是一个异常处理方法。
	 * e: 处理器方法所抛出的异常。
	 */
	public String handlerEx(Exception e,
			HttpServletRequest request){
		System.out.println("handleEx()");
		if(e instanceof 
				NumberFormatException){
			e.printStackTrace();
			request.setAttribute("msg",
					"亲，请输入正确的数字");
			return "error3";
		}
		if(e instanceof 
				StringIndexOutOfBoundsException){
			e.printStackTrace();
			request.setAttribute("msg",
					"下标越界啦");
			return "error3";
		}
		return "error";
	}
	
	
	@RequestMapping("/hello.do")
	public String hello(){
		System.out.println("hello()");
		Integer.parseInt("123a");
		return "hello";
	}
	
	@RequestMapping("/hello2.do")
	public String hello2(){
		System.out.println("hello2()");
		String str = "abcd";
		str.charAt(10);
		return "hello";
	}
}

