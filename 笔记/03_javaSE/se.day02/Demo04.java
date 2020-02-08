package day02;
/**
 * 用户名规则 
 */
public class Demo04 {
	public static void main(String[] args) {
		//用户名: 8到11个单词字符
		String reg = "\\w{8,11}";
		//String reg = "[a-zA-Z_0-9]{8,11}";
		String name = "wulanbutong";
		boolean b = name.matches(reg);
		System.out.println(b); 
	}

}
