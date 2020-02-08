package cn.tedu.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope("prototype")
public class RedirectDemoAction 
	extends AbstractAction{
	
	public String execute() {
		System.out.println("重定向请求");
		return SUCCESS;
	}
}







