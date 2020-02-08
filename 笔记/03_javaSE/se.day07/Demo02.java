package day07;

import java.io.RandomAccessFile;

/**
 * RAF 整数数据读写
 *
 */
public class Demo02 {
	public static void main(String[] args) 
		throws Exception{
		String file = "abc/integer.dat";
		RandomAccessFile raf = 
			new RandomAccessFile(file, "rw");
		//将int数据126712 拆分为4个byte写到
		//文件中，文件指针连续移动4次
		raf.writeInt(126712); 
		long p = raf.getFilePointer();
		System.out.println(p);
		raf.seek(0);
		//读取一个整数: 连续读取4个byte，拼接
		// 为一个int数据, 文件指针连续移动4次
		int n = raf.readInt();
		p = raf.getFilePointer();
		System.out.println(p);//4
		System.out.println(n);//126712
		raf.close();
	}
}






