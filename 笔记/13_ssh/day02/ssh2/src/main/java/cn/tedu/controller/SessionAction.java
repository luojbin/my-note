package cn.tedu.controller;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
/**
 * 自动注入Session对象. 
 * Struts主控制器在发现控制器类,  SessionController
 * 实现了SessionAware时候, 会自动的将Session对象
 * 注入到 控制器对象中. 注入时候调用的方法是setSession 
 */
public class SessionAction
	implements SessionAware{
	
	private Map<String, Object> session;
	
	public void setSession(
			Map<String, Object> session) {
		this.session=session;
	}
	
	public String demo(){
		session.put("name", "Tom");
		return "success";
	}
	
}





