package day06;

import java.io.File;
/**
 * 检查磁盘文件是否存在 
 */
public class Demo02 {
	public static void main(String[] args) {
		File file=new File("demo/hello.txt");
		//exists: 检查file对象代表的硬盘文件
		//是否存在，如果存在则true，否则false
		boolean b = file.exists();
		System.out.println(b);//true
		file.delete();
		b = file.exists();
		System.out.println(b);//false
	}
}



