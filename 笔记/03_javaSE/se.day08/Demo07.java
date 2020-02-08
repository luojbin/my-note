package day08;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * 利用BufferedReader读取文本文件 
 */
public class Demo07 {
	public static void main(String[] args) 
		throws Exception{
		String file = "abc/day07.md";
		FileInputStream fis = 
			new FileInputStream(file);
		BufferedInputStream bis=
			new BufferedInputStream(fis);
		InputStreamReader isr = 
			new InputStreamReader(
			bis,"UTF-8");
		//BufferedReader  是高级流
		BufferedReader in=
			new BufferedReader(isr);
		/**
		 * readLine 返回文本文件中的一行数据
		 * 不包含回车字符，当读取到文件末尾时候
		 * 返回null
		 */
		String str;
		while((str=in.readLine())!=null){
			System.out.println(str);
		}
		in.close();
	}
}







