package day03;
/**
 * 将10进制字符串转换为int数据（2进制） 
 *
 * 在编程中如果需要将10进制字符串转换为
 * int类型数据时候可以调用这个方法
 */
public class Demo06 {
	public static void main(String[] args) {
		String str = "-12561";
		int i = Integer.parseInt(str);
		System.out.println(i);//
		
		//str = "Abnc123";
		//i = Integer.parseInt(str);
		
		str = "3.14";
		double pi = Double.parseDouble(str);
		System.out.println(pi);
		
		str = "true";
		boolean b = Boolean.parseBoolean(str);
		System.out.println(str);
 	}
}










