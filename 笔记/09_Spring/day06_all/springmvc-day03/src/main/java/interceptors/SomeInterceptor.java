package interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class SomeInterceptor implements 
HandlerInterceptor{

	/**
	 * 最后执行的方法。
	 * arg3 是Controller所抛出的异常。
	 */
	public void afterCompletion(
			HttpServletRequest arg0, 
			HttpServletResponse arg1, 
			Object arg2, Exception arg3)
			throws Exception {
		System.out.println("afterCompletion()");
	}

	/**
	 * Controller的方法已经执行完毕，
	 * 正准备将ModelAndView返回给
	 * DispatcherServlet之前，执行
	 * postHandle方法。可以在该方法里面，
	 * 修改处理结果(ModelAndView)。
	 */
	public void postHandle(
			HttpServletRequest arg0, 
			HttpServletResponse arg1, 
			Object arg2, ModelAndView arg3)
			throws Exception {
		System.out.println("postHandle()");
	}

	/**
	 * DispatcherServlet在收到请求之后，
	 * 会先调用preHandle方法。如果该方法
	 * 的返回值是true,则继续向后调用；
	 * 如果返回值是false,则中断请求。
	 * 注：
	 * 	 DispatcherServlet,拦截器以及
	 * Controller会共享同一个request,response。
	 * 	arg2:Controller的方法对象。 
	 */
	public boolean preHandle(
			HttpServletRequest arg0, 
			HttpServletResponse arg1, 
			Object arg2) throws Exception {
		System.out.println("preHandle()");
		return true;
	}
	
}


