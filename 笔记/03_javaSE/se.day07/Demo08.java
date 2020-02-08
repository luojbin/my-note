package day07;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * 利用文件流实现文件的复制功能 
 * 
 * 在不使用缓冲流的情况下，读写性能很差！
 * 
 */
public class Demo08 {
	public static void main(String[] args) 
		throws Exception{
		//打开原始输入文件
		FileInputStream fis =
			new FileInputStream(
			"d:/TETRIS.zip");
		
		BufferedInputStream in =
			new BufferedInputStream(fis);
				
		//打开目标的输出文件
		FileOutputStream fos = 
			new FileOutputStream(
			"d:/TETRIS_new.zip");
		
		BufferedOutputStream out=
			new BufferedOutputStream(fos); 
			
		
		//从in里读取每个byte写到out流中
		int b;
		while((b=in.read())!=-1){
			//b代表原始文件中的每个byte
			out.write(b); 
		}
		//关闭in，out即可
		in.close(); 
		out.close();
		System.out.println("成功！");
	}
}






