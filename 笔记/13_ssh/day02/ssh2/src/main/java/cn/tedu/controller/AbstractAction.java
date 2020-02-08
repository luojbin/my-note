package cn.tedu.controller;

import java.util.Map;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public abstract class AbstractAction 
	extends ActionSupport
	implements SessionAware,
	RequestAware, 
	ApplicationAware{
	
	protected Map<String, Object> request;
	protected Map<String, Object> session;
	protected Map<String, Object> application;
	
	public void setSession(
			Map<String, Object> session) {
		this.session=session;
	}
	public void setRequest(
			Map<String, Object> request) {
		this.request=request;
	}
	public void setApplication(
			Map<String, Object> application) {
		this.application=application;
	}
	
}
