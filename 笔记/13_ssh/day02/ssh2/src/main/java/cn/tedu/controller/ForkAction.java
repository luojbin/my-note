package cn.tedu.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope("prototype")
public class ForkAction extends AbstractAction{
	
	private String target;
	public void setTarget(String target) {
		this.target = target;
	}
	public String getTarget() {
		return target;
	}
	
	public String execute(){
		if("doc".equals(target)){
			return "doc";
		}
		if("success".equals(target)){
			return SUCCESS;
		}
		return ERROR;
	}
}




