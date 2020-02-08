package day01;

/**
 * trim 去除字符串两端的“空白”字符 
 */
public class Demo10 {

	public static void main(String[] args) {
		String str = " \t Tom \n \r";
		//去除str字符串两端的空白，返回新字符串
		String s = str.trim();
		System.out.println("["+str+"]");
		System.out.println("["+s+"]");
		System.out.println(str==s);
		
		System.out.println((int)' '); 
		System.out.println((int)'\t'); 
		System.out.println((int)'\n');
		System.out.println((int)'\r');
		
		
		String name = "Tom";
		String n = name.trim();
		System.out.println(n);
		System.out.println(name);
		System.out.println(n == name);
		
		
	}

}


