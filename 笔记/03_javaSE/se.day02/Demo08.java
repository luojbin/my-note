package day02;

/**
 * 测试从头到尾 
 */
public class Demo08 {
	public static void main(String[] args) {
		String reg = "^\\w{8,10}$";
		String name = "TomAndJerry";
		//matches 方法总是按照从头到尾的规则
		//检查字符串的是否符合正则表达式
		if(name.matches(reg)){
			System.out.println("输入合法"); 
		}else{
			System.out.println("输入错误");
		}
	}

}
