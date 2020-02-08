package cn.tedu.controller;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

import cn.tedu.vo.UserValue;

public class UserAction {
	
	private UserValue userValue;
	
	public void setUserValue(UserValue userValue) {
		this.userValue = userValue;
		System.out.println("setUserValue");
	}
	
	public UserValue getUserValue() {
		System.out.println("getUserValue");
		return userValue;
	}
	
	private String message;

	public String getMessage() {
		return message;
	}
	
	public String execute(){
		System.out.println(userValue);
		message = "成功!";
		
		//转发目标JSP收到两个Bean对象: 
		// message 和 userValue
		//对应着 Action 对象的 getXXX方法
		//在JSP中可以使用 EL 表达式访问这些属性
		
		//将数据保存到 session
		ActionContext context = 
				ActionContext.getContext();
		Map<String, Object> session = 
				context.getSession();
		session.put("loginUser", "Tom");
		
		//struts 2 会自动的将 map 中的数据同步到
		// HttpSession 中
		
		//转发到JSP 后可以使用EL获取 session 中的数据
		// ${loginUser}
		return "success";
	}
}


