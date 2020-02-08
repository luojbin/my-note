package cn.tedu.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope("prototype")
//转换为json: {name:"Tom", age:10}
public class JsonDemoAction {
	private String name;
	private int age;
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
	public String execute(){
		name = "Tom";
		age = 10;
		return "success";
	}
}


