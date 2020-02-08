package day02;

public class Demo03 {
	public static void main(String[] args) {
		//身份证的规则
		String reg = "\\d{17}[\\dXx]";
		String code = "12201220101212122X";
		boolean b = code.matches(reg);
		System.out.println(b); 
	}
}
