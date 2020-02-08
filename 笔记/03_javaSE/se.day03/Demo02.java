package day03;
/**
 * 字符串重写了 equals  
 */
public class Demo02 {
	public static void main(String[] args) {
		String s1 = "abc";
		String s2 = "abc";
		String s3 = new String("abc");
		String s4 = new String("abc");
		//== 不能用于比较字符串内容是否相等
		System.out.println(s1==s2);//true
		System.out.println(s1==s3);//false
		//使用equals才能正确比较字符串内容
		System.out.println(s1.equals(s2));//true
		System.out.println(s1.equals(s3));//true
	}
}
