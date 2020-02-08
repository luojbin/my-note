package cn.tedu.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope("prototype")
public class RootDemoAction extends AbstractAction{
	
	private Object jsonResult;
	
	public void setJsonResult(Object jsonResult) {
		this.jsonResult = jsonResult;
	}
	public Object getJsonResult() {
		return jsonResult;
	}
	
	public String execute(){
		String[] ary={"Tom", "Andy"};
		jsonResult = ary;
		return SUCCESS;
	}
}


