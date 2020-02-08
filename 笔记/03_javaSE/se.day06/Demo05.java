package day06;

import java.io.File;

/**
 * 不能删除非空文件夹 
 * 首先准备实验素材：test/demo.txt
 */
public class Demo05 {
	public static void main(String[] args) {
		//创建file对象代表文件夹
		File dir=new File("test");
		boolean b=dir.isDirectory();
		System.out.println(b);//true
		boolean success=dir.delete();
		System.out.println(success);//false
		//test 文件夹中包含文件，这时
		//不能直接删除。delete()返回false
	}

}
