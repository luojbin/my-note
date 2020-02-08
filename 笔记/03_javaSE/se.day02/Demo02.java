package day02;
/**
 * 正则表达式案例1  
 */
public class Demo02 {
	public static void main(String[] args) {
		String code = "100101";
		//String reg = 
		//	"[0-9][0-9][0-9][0-9][0-9][0-9]";
		//定义邮政编码的规则
		String reg = "\\d{6}";
		//检查code要符合 reg约定的规则
		//matches 匹配
		boolean b = code.matches(reg);
		System.out.println(b);
		code = "123abc";
		b = code.matches(reg);
		System.out.println(b); //false
	}
}
