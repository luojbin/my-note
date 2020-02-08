package day07;

import java.io.RandomAccessFile;

/**
 * 字符串类型的写出和读取 
 */
public class Demo03 {
	public static void main(String[] args) 
		throws Exception{
		String file="abc/str.txt";
		RandomAccessFile raf = 
			new RandomAccessFile(file, "rw");
		String str = "你好ABC";
		//对字符串进行UTF-8编码
		byte[] bytes=str.getBytes("UTF-8");
		System.out.println(bytes.length);//9
		//将文字的编码写入到文件中
		raf.write(bytes);//将数组中全部的byte
		//数据写入到文件中。
		long p = raf.getFilePointer();
		System.out.println(p);//9
		//从头读取
		raf.seek(0);
		byte[] buf=new byte[(int)raf.length()];
		//read(bytes) 从文件中连续读取byte数据
		//将读取结果填充到 byte数组中
		raf.read(buf);
		//buf 中是按照UTF-8编码的字符数据,解码：
		String s = new String(buf, "UTF-8");
		System.out.println(s); 
		raf.close();
	}
}




