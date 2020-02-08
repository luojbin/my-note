package cn.tedu.note.web;

import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

import cn.tedu.note.action.AbstractAction;

@Component
public class ExceptionInterceptor implements Interceptor {

	public void destroy() {
	}

	public void init() {
	}

	public String intercept(
			ActionInvocation invocation) 
					throws Exception {
		//得到目标控制器 
		AbstractAction action  = 
				(AbstractAction)invocation.getAction();
		//调用目标控制器的方法
		String val = null;
		try {
			val = invocation.invoke();
		} catch (Exception e) {
			val = action.handleException(e);
		}
		if(val == null){
			throw new NullPointerException();
		}
		return val;
	}

}




