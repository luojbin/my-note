package day01;
/**
 * 利用trim消除用户意外输入的空白信息，
 * 提高用户的体验。
 */
public class Demo11 {
	public static void main(String[] args) {
		String name = "Tom ";
		//空白可能会照成用户体验下降
		System.out.println(name.equals("Tom"));
		//利用trim改善用户体验
		System.out.println(
				name.trim().equals("Tom"));
		
	}

}
