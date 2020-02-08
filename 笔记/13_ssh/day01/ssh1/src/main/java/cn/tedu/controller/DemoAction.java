package cn.tedu.controller;

public class DemoAction {
	
	/**
	 * Struts2 控制器中的默认处理方法名为execute
	 * @return 返回视图的名称
	 */
	public String execute(){
		System.out.println("Hello World!");
		return "success";
	}
}
