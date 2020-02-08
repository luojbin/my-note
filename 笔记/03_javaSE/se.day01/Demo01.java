package day01;

/**
 * 测试字符串常量重用现象
 */
public class Demo01 {
	public static final String S = "123abc";
	public static void main(String[] args) {
		//字符串字面量替换为同一个字符串对象
		String s1 = "123abc";
		String s2 = "123abc";
		//如下比较结果是true，则表示s1和s2
		//的值（地址值）是相等的，
		//即s1 s2引用同一个字符串对象！
		System.out.println(s1==s2);
		
		String s3 = "123";
		System.out.println(s1==s3);//false
		
		//字符串常量参与字符串字面量重用
		System.out.println(s1==S);//true
		//测试结果说明：s1和S引用了同一个字符串对象
		
		String s4 = "123abc";
		String s5 = 123+"abc";
		System.out.println(s4==s5);//true
		
		
	}
}





