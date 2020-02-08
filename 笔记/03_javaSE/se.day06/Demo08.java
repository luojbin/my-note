package day06;

import java.io.File;

/**
 * 创建文件夹 
 */
public class Demo08 {
	public static void main(String[] args) {
		File file = new File("abc");
		//mkdir()用于创建文件夹，如果成功
		//创建文件夹，则返回true，否则false
		boolean b = file.mkdir();
		System.out.println(b);//true
		//创建系列文件夹
		File file2=new File("def/demo/test");
		//mkdirs 用于创建一系列父子文件夹
		b = file2.mkdirs();
		System.out.println(b); 
		//使用绝对路径创建文件夹
		File file3=new File("d:/demo/test");
		//new File("/home/soft01/demo/test");
		file3.mkdirs();
	}
}







