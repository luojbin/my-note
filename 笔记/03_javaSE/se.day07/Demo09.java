package day07;

import java.io.FileInputStream;
import java.io.FileOutputStream;
/**
 * 自定义缓存读写 
 */
public class Demo09 {
	public static void main(String[] args) 
		throws Exception{
		//打开原始输入文件
		FileInputStream in =
			new FileInputStream(
			"d:/TETRIS.zip");
		//打开目标的输出文件
		FileOutputStream out = 
			new FileOutputStream(
			"d:/TETRIS_new.zip");
		byte[] buf=new byte[1024*8];//1K byte
		//从输入流in中读取尽可能多的byte填充
		//到缓存 buf 中，返回读取个数 1024
		//int n = in.read(buf);//1024
		//int n = in.read(buf);//1024
		//...
		//n = in.read(buf); // 1 ~ 1024
		//n = in.read(buf); // -1
		int n;
		while((n = in.read(buf))!=-1){
			//将buf中从0开始的连续n个byte
			//写到 文件流out中
			out.write(buf, 0, n);
		}
		
		in.close();
		out.close();
		System.out.println("OK!");
	}
}
