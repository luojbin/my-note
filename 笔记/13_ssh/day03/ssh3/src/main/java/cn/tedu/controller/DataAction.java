package cn.tedu.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * 利用 ValueStack 共享数据 
 */
@Controller
@Scope("prototype")
public class DataAction extends AbstractAction{
	
	//在内容区域共享数据, 利用控制器的Bean属性
	private String name;
	private int age;
	//@Value("#{cfg.data}")
	private String target; //目标网页名
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	
	public String execute(){
		
		//上下文区域(环境) Context 区域, 共享数据
		request.put("message", "Struts 测试");
		session.put("loginState", "已经登录");
		application.put("count", 55);
		
		name="老王";
		age = 123;
		target = "show.jsp";//目标视图页面
		
		return SUCCESS;
	}
}





