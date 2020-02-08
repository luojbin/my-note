package day08;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

/**
 * 缓存对IO的影响 
 */
public class Demo01 {
	public static void main(String[] args) 
		throws Exception{
		String file="abc/test.txt";
		FileOutputStream fos = 
			new FileOutputStream(file);	
		BufferedOutputStream out=
			new BufferedOutputStream(fos);
		//缓存流将数据写到缓存中，当缓存满了的
		//时候在成批（8K）的写到文件中
		out.write(65);
		out.write(66);
		out.write(66);
		//将缓存清空，数据写到文件中
		//清空缓存，文件不关闭可以继续写文件
		out.flush();
		out.write(67); 
		//关闭方法包含清空缓存的功能
		//out.close();
		//out.write(67); //不能再写文件了
	}
}





