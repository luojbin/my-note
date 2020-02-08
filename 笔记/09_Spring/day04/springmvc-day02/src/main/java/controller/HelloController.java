package controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

/**
 * 处理器类
 * 	1.不用实现Controller接口
 *  2.方法名不做要求，返回值可以是
 *  ModelAndView,也可以是String。
 *  3.可以添加多个方法。
 *  4.使用@Controller 。
 *	5.可以在方法前或者类前添加
 *	@RequestMapping (相当于HandlerMapping)
 */
@Controller
public class HelloController {
	
	@RequestMapping("/hello.do")
	public String hello(){
		System.out.println("hello()");
		//返回视图名
		return "hello";
	}
	
	@RequestMapping("/toLogin.do")
	public String toLogin(){
		System.out.println("toLogin()");
		return "login";
	}
	
	@RequestMapping("/login.do")
	/*
	 * DispatcherServlet在调用处理器的方法
	 * 之前，会利用java反射机制分析方法的
	 * 结构，比如这儿，通过分析，会将request
	 * 对象传过来(了解)。
	 */
	public String login(
			HttpServletRequest request){
		System.out.println("login()");
		String adminCode = 
				request.getParameter(
						"adminCode");
		System.out.println("adminCode:"
						+ adminCode);
		return "index";
	}
	
	
	@RequestMapping("/login2.do")
	/*
	 * DispatcherServlet调用处理器的方法之前，
	 * 会分析方法的结构。这儿，会调用request对象的
	 * 方法，先获得参数值，然后赋给对应的形
	 * 参。(了解)
	 * 如果不一致，要使用@RequestParam注解。
	 * 
	 */
	public String login2(String adminCode,
			@RequestParam("pwd") 
		String password){
		
		System.out.println("login2()");
		System.out.println("adminCode:"
		+ adminCode + " pwd:" + password);
		return "index";
	}
	
	@RequestMapping("/login3.do")
	/*
	 * DispatcherServlet会将AdminParam
	 * 对象创建好（会将请求参数值赋给相应的
	 * 属性）。
	 */
	public String login3(AdminParam ap){
		System.out.println("login3()");
		String adminCode = 
				ap.getAdminCode();
		System.out.println("adminCode:"
				+ adminCode);
		return "index";
	}
	
	@RequestMapping("/login4.do")
	public String login4(AdminParam ap,
			HttpServletRequest request){
		System.out.println("login4()");
		String adminCode = 
				ap.getAdminCode();
		request.setAttribute("adminCode",
				adminCode);
		//默认情况下，DispatcherServlet
		//会使用转发。
		return "index";
	}
	
	@RequestMapping("/login5.do")
	public ModelAndView login5(
			AdminParam ap){
		System.out.println("login5()");
		String adminCode = 
				ap.getAdminCode();
		//step1.将数据添加到Map对象里面
		Map<String,Object> data = 
			new HashMap<String,Object>();
		//相当于执行了request.setAttribute
		data.put("adminCode", adminCode);
		//step2. 将Map对象添加到ModelAndView
		ModelAndView mav = 
				new ModelAndView("index",
						data);
		return mav;
	}
	
	@RequestMapping("/login6.do")
	public String login6(AdminParam ap,
			ModelMap mm){
		System.out.println("login6()");
		String adminCode = 
				ap.getAdminCode();
		//相当于执行了request.setAttribute
		mm.addAttribute("adminCode",
				adminCode);
		return "index";
	}
	
	@RequestMapping("/login7.do")
	public String login7(AdminParam ap,
			HttpSession session){
		System.out.println("login7()");
		String adminCode = 
				ap.getAdminCode();
		session.setAttribute("adminCode",
				adminCode);
		return "index";
	}
	
	@RequestMapping("/login8.do")
	public String login8(){
		System.out.println("login8()");
		return "redirect:toIndex.do";
	}
	
	@RequestMapping("/toIndex.do")
	public String toIndex(){
		System.out.println("toIndex()");
		return "index";
	}
	
	@RequestMapping("/login9.do")
	public ModelAndView login9(){
		System.out.println("login9()");
		RedirectView rv = 
				new RedirectView("toIndex.do");
		ModelAndView mav = 
				new ModelAndView(rv);
		return mav;
	}
	
	
}








