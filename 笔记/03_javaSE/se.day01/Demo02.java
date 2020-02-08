package day01;
/**
 * 字符串常量和字面量的运算结果参与重用 
 *
 */
public class Demo02 {
	public static final String SS = "tom";

	public static void main(String[] args) {
		String s1 = "tom and jerry";
		String s2 = SS + " and jerry";
		System.out.println(s1==s2);//true
		
		//思考：字符串字面量和常量的连接运算
		//对Java运行性能有影响吗？
	
	}
}




