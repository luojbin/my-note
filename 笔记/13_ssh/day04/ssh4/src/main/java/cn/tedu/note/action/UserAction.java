package cn.tedu.note.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.tedu.note.entity.User;
import cn.tedu.note.service.UserService;
import cn.tedu.note.util.JsonResult;

@Controller
@Scope("prototype")
public class UserAction extends AbstractAction{

	@Resource
	private UserService userService; 
	
	private String name;
	private String password;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String login(){
		User user = userService.login(name, password);
		session.put("loginUser", user);
		jsonResult=new JsonResult(user);
		return JSON;
	}
	
	private String nick;
	private String confirm;
	
	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getConfirm() {
		return confirm;
	}

	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}

	public String regist(){
		User user = userService.regist(
			name, nick, password, confirm);
		
		jsonResult = new JsonResult(user);
		return JSON;
	}
	
	
}





