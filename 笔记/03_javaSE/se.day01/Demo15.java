package day01;
/**
 * StringBuilder 的构造器 
 */
public class Demo15 {
	public static void main(String[] args) {
		StringBuilder s1=new StringBuilder();
		StringBuilder s2=
				new StringBuilder("123");
		System.out.println(s1);
		System.out.println(s2);
		
		s1.append("Hello");
		//append 追加：将字符串追加到
		//StringBuilder中
		System.out.println(s1);//Hello
	}
}


