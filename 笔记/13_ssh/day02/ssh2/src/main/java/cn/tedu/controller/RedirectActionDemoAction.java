package cn.tedu.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope("prototype")
public class RedirectActionDemoAction 
	extends AbstractAction{
		
	public String execute(){
		System.out.println("重定向到其他控制器");
		return SUCCESS;
	}
}
