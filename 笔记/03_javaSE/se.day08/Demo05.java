package day08;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * 读取文本信息 
 */
public class Demo05 {
	public static void main(String[] args) 
		throws Exception{
		String file="abc/osw.txt";
		FileInputStream fis=
			new FileInputStream(file);
		BufferedInputStream bis=
			new BufferedInputStream(fis);
		//使用 InputStreamReader
		//InputStreamReader 是高级流，必须依赖
		//基本的字节流，扩展了字符的解码功能
		//将字节流中的byte数据读取后进行字符
		//解码 得到解码以后的字符数据
		InputStreamReader reader=
			new InputStreamReader(
			bis, "utf-8");//GBK
		//读取字符,返回0~65535之间的字符
//		int c = reader.read();
//		char ch = (char)c;
//		System.out.println(ch);
//		c = reader.read();
//		ch = (char)c;
//		System.out.println(ch);
		int c;
		while((c = reader.read())!=-1){
			char ch = (char)c;
			System.out.println(ch); 
		}
		reader.close();
	}
}










