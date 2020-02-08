package day01;

import java.util.Scanner;

/**
 *
 */
public class Demo03 {
	public static void main(String[] args) {
		//新建字符串和字符串运算结果是不参与
		//字符串静态池重用
		Scanner in = new Scanner(System.in); 
		System.out.print("输入字符串：");
		String name = in.nextLine();//Tom
		String s1 = "Tom and Jerry";
		String s2 = name + " and Jerry";
		System.out.println(s1==s2);//false
		String s3 = new String("Tom and Jerry");
		System.out.println(s3==s1);//false
	}

}
