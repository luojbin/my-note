package day01;

import java.util.Scanner;

public class Demo06 {

	public static void main(String[] args) {
		Scanner in= new Scanner(System.in);
		System.out.print("输入一句话：");
		String str = in.nextLine();
		int n = str.indexOf("我去");
		if(n>=0){
			System.out.println("你要注意言行！");
		}
	}

}
