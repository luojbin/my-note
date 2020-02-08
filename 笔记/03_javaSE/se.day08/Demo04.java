package day08;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

/**
 * 字符输出流
 */
public class Demo04 {
	public static void main(String[] args) 
		throws Exception {
		String file = "abc/osw.txt";
		FileOutputStream fos=
			new FileOutputStream(file);
		BufferedOutputStream bos=
			new BufferedOutputStream(fos);
		//OutputStreamWriter是高级流，必须依赖
		//其他的字节流，扩展的字符编码功能
		OutputStreamWriter writer=
			new OutputStreamWriter(
			bos, "utf-8");
		//将字符输出到文件
		//将30000（田）编码为UTF-8的byte数据
		//并且将byte写到文件中。
		writer.write(30000); 
		writer.write("田地");
		char[] chs = 
			{'你','好','J','A','V','A'};
		writer.write(chs);
		writer.write(chs,2,4);
		//关闭高级流就可以关闭文件了
		writer.close();
		
	}

}



