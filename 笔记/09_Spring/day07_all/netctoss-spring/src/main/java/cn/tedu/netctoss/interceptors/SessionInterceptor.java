package cn.tedu.netctoss.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 用于session验证的拦截器
 *
 */
public class SessionInterceptor implements 
HandlerInterceptor{

	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		
	}

	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		
	}

	public boolean preHandle(
			HttpServletRequest request,
			HttpServletResponse response,
			Object arg2) throws Exception {
		System.out.println(
			"SessionInterceptor's preHandle()");
		//先获得session对象
		HttpSession session = 
				request.getSession();
		//从session对象当中获取特定的数据
		Object obj = 
				session.getAttribute("admin");
		if(obj == null){
			//获取不到数据，说明没有登录
			response.sendRedirect("toLogin.do");
			//中断请求（不再向后调用）
			return false;
		}
		//能够获取数据，说明登录过了
		//继续向后调用。
		return true;
	}
	
}





