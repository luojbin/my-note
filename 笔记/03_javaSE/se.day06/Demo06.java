package day06;

import java.io.File;

/**
 * 创建file对象，代表某个文件夹中的某个文件 
 */
public class Demo06 {
	public static void main(String[] args) {
		//创建file对象代表文件夹
		File dir=new File("test");
		//创建file对象代表 文件夹中的文件
		File file=new File(dir, "demo.txt");
		//如上file代表 test文件夹中的demo.txt
		//文件
		boolean b = file.exists();
		System.out.println(b); 
	}
}




