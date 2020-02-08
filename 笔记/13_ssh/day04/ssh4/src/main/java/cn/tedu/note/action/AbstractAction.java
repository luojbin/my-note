package cn.tedu.note.action;

import java.util.Map;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import cn.tedu.note.util.JsonResult;

public abstract class AbstractAction 
	extends ActionSupport
	implements SessionAware,
	RequestAware, 
	ApplicationAware{
	
	protected static final String JSON="json";
	
	protected Map<String, Object> request;
	protected Map<String, Object> session;
	protected Map<String, Object> application;
	//Json返回值
	protected JsonResult jsonResult;
	public JsonResult getJsonResult() {
		return jsonResult;
	}
	public void setJsonResult(JsonResult jsonResult) {
		this.jsonResult = jsonResult;
	}
	
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
	
	//AbstractAction 中约定控制器处理异的方法
	public String handleException(Exception e) {
		e.printStackTrace();
		jsonResult = new JsonResult(e);
		return JSON;
	}
	
}






