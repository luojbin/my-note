package day06;

import java.io.File;

/**
 * File API 的使用
 *
 */
public class Demo01 {
	public static void main(String[] args) {
		//创建file 对象，代表硬盘上的文件
		File file=new File("demo/test.txt");
		//有了file对象后就可以利用File类
		//提供的API方法操作 demo/test.txt文件
		//delete：删除file所代表的硬盘文件
		boolean success = file.delete();
		System.out.println(success);
		//当删除成功时候返回 true，
		//删除失败时候返回false
		success = file.delete();
		System.out.println(success); 
		//检查file对象在硬盘上对应的文件是否存在
		file.exists();
	}	
}





