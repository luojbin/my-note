package cn.tedu.note.web;

import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

import cn.tedu.note.action.AbstractAction;

@Component
public class MyInterceptor 
	implements Interceptor {

	public void destroy() {}

	public void init() {}

	public String intercept(
			ActionInvocation invocation) 
			throws Exception {
		System.out.println("控制器之前");
		String val = invocation.invoke();
		System.out.println("控制器之后"); 
		return val;
	}

}
