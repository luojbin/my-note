package cn.tedu.controller;

/**
 * 利用Bean属性接收用户提交的参数 
 */
public class ParamAction {
	
	private String name;
	private int age;
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public String execute(){
		System.out.println("name:"+name);
		System.out.println("age:"+age);
		return "success";
	}
}
