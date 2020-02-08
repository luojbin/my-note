package day06;

import java.io.File;

/**
 * 列文件夹的内容 
 */
public class Demo11 {
	public static void main(String[] args) {
		//创建file对象代表test文件夹
		// new File("D:/");
		// new File("/home/soft01/");
		File dir=new File("test");
		//查询 test文件夹的内容列表
		//返回值是File类型的数组，有的是
		//文件有的是文件夹
		File[] files=dir.listFiles();
		//在控制台输出文件夹中全部的内容
		for(File file:files){
			//文件夹显示为： [文件夹名]
			if(file.isDirectory()){
				System.out.println(
						"["+file.getName()+"]"); 
			}else{
				System.out.println(
						file.getName());
			}
		}
	}
}





