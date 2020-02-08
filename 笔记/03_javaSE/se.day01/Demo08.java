package day01;

import java.util.Scanner;

/**
 * 截取子字符串案例 
 */
public class Demo08 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("URL:");
		String url = in.nextLine();
		//String url="http://tedu.cn/index.html";
		//从当前位置开始截取到字符串的最后位置
		int i = url.lastIndexOf("/");
		//String filename = url.substring(15);
		String filename = url.substring(i+1);
		System.out.println(filename); 
	}

}
