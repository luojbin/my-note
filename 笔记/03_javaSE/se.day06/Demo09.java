package day06;

import java.io.File;

/**
 * 利用File API 创建文件
 * 
 */
public class Demo09 {
	public static void main(String[] args) 
		throws Exception{
		File file = new File("test/abc.txt");
		//调用file对象的API方法
		//create:创建
		//createNewFile: 创建新文件
		//如果创建成功返回true，创建失败
		//返回false，如果没有写入权限，则
		//出现异常！！
		boolean b = file.createNewFile();
		System.out.println(b);//true
		//使用绝对路径创建文件
	}
}





