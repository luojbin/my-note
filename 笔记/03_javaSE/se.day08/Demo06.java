package day08;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/**
 * 利用PrintWriter 写文本文件 
 */
public class Demo06 {
	public static void main(String[] args) 
		throws Exception{
		String file="abc/pw.txt";
		FileOutputStream fos=
			new FileOutputStream(file);
		BufferedOutputStream bos=
			new BufferedOutputStream(fos);
		OutputStreamWriter osw =
			new OutputStreamWriter(
			bos, "utf-8");
		//PrintWriter：是高级流，扩展了println
		//方法和print
		// true 自动清理缓存功能，每个println方法
		//之后会执行一个  flush方法
		PrintWriter out=new PrintWriter(osw, true);
		out.println("Hello World!");
		out.close();
	}
}





