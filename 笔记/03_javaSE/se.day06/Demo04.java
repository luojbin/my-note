package day06;

import java.io.File;

/**
 * File 可以代表文件夹 
 */
public class Demo04 {
	public static void main(String[] args) {
		//dir 就代表硬盘上的一个文件夹
		File dir=new File("demo");
		//File API 提供了检查是否是文件夹的方法
		//isDirectory 返回true是文件夹
		boolean b = dir.isDirectory();
		System.out.println(b); //true
		//删除文件夹！只能删除空文件夹！
		dir.delete();
		//此时file对象，没有被代表的文件、文件夹
		//这时候 file对象：不是文件，不是文件夹
		// 也不存在
		b = dir.isDirectory();
		System.out.println(b); 
	}
}




