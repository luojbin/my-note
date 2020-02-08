package cn.tedu.netctoss.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.tedu.netctoss.entity.Admin;
import cn.tedu.netctoss.service.ApplicationException;
import cn.tedu.netctoss.service.LoginService;
import cn.tedu.netctoss.util.ImageUtil;

@Controller
public class LoginController {
	
	@Resource(name="loginService")
	private LoginService loginService;
	
	@RequestMapping("/checkcode.do")
	//返回验证码图片
	public void checkcode(
			HttpServletResponse response) throws IOException{
		//通过工具类ImageUtil获得验证码图片
		BufferedImage image = 
				(BufferedImage) ImageUtil
				.createImage()[1];
		//将验证码图片发送给浏览器
		OutputStream os = 
				response.getOutputStream();
		javax.imageio.ImageIO.write(
				image, "jpeg", os);
		os.close();
	}
	
	@ExceptionHandler
	public String handleEx(Exception e,
			HttpServletRequest request){
		System.out.println("handleEx()");
		if(e instanceof ApplicationException){
			//应用异常
			request.setAttribute(
					"login_failed",
					e.getMessage());
			return "login";
		}
		//系统异常
		return "error";
	}
	
	@RequestMapping("/toLogin.do")
	public String toLogin(){
		System.out.println("toLogin()");
		return "login";
	}
	
	@RequestMapping("/login.do")
	public String login(
			HttpServletRequest request,
			HttpSession session){
		System.out.println("login()");
		//读取帐号，密码
		String adminCode = 
				request.getParameter(
						"adminCode");
		System.out.println("adminCode:"
						+ adminCode);
		String pwd = 
				request.getParameter("pwd");
		//调用业务层提供的服务
		Admin admin = 
			loginService.checkLogin(
				adminCode, pwd);
		//登录成功，将一些数据绑订到
		//session对象上。
		session.setAttribute("admin",
					admin);
		return "redirect:toIndex.do";
	}
	
	@RequestMapping("/toIndex.do")
	public String toIndex(){
		System.out.println("toIndex()");
		return "index";
	}
}




