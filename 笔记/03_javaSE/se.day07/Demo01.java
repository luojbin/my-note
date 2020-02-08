package day07;

import java.io.RandomAccessFile;

/**
 * 随机文件读写 
 *
 */
public class Demo01 {
	public static void main(String[] args) 
		throws Exception{
		String file = "abc/myfile.dat";
		RandomAccessFile raf=
			new RandomAccessFile(file, "rw");
		//将0~255写入到文件 myfile.dat
		for(int i=0; i<=255; i++){
			raf.write(i);
		}
		//移动读写位置指针到0
		raf.seek(0);//可以在任意位置开始读写
		int b;
		//经典的模式写法：
		while((b=raf.read())!=-1){
			System.out.println(b);
		}
		raf.close();
	}
}







