package cn.tedu.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope("prototype")
public class HelloAction extends AbstractAction {
	public String execute(){
		System.out.println("Hello World!");
		return SUCCESS;
	}
}
