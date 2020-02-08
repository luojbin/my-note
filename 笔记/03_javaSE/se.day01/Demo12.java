package day01;
/**
 * 利用大小写转换实现忽略大小比较字符串是否相等 
 */
public class Demo12 {
	public static void main(String[] args) {
		String code = "aD12F ";
		String c = "AD12F";
		//将字符串转换为大写字符
		String s = code.trim().toUpperCase();
		//s = "AD12F"
		//比较字符串是否相等
		System.out.println(c.equals(s)); 
		System.out.println(code.equals(s)); 
	}

}
