package day03;
/**
 * 自动拆包和自动包装 
 */
public class Demo07 {
	public static void main(String[] args) {
		Integer i = 5;//自动包装
		int j = i;//自动拆包
		
		int num = i * 6 + j;
		Integer x = i * 6 + j;
		
		System.out.println(num);
		System.out.println(x);
		
	}

}
