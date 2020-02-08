package cn.tedu.controller;

public class DemoAction extends AbstractAction{

	public String execute(){
		request.put("myName", "Wang");
		session.put("name", "Andy");
		application.put("test", "熊大");
		return SUCCESS;
	}
	
}
