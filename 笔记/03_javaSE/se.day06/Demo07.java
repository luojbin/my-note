package day06;

import java.io.File;
import java.util.Date;

/**
 * 读取一个文件夹、文件的全部属性
 * 素材：test/demo.txt 
 */
public class Demo07 {
	public static void main(String[] args) {
		File dir=new File("test");
		File file=new File(dir, "demo.txt");
		//dir代表一个文件夹
		//file 代表一个文件
		//检查是否是文件
		System.out.println(dir.isFile());
		System.out.println(file.isFile());
		//检查文件的长度
		long length = file.length();
		System.out.println(length); 
		//检查文件的最后修改时间
		long time = file.lastModified();
		Date date = new Date(time);
		System.out.println(date);
		//检查文件的读写属性
		boolean read=file.canRead();
		boolean write=file.canWrite();
		boolean hidden = file.isHidden();
		
		System.out.println(read);
		System.out.println(write);
		System.out.println(hidden);
	}

}


