package day06;

import java.io.RandomAccessFile;

import javax.swing.plaf.synth.SynthSpinnerUI;

/**
 * RAF 读取文件
 *
 */
public class Demo16 {
	public static void main(String[] args) 
		throws Exception {
		//以只读访问打开文件
		String file = "abc/demo.txt";
		RandomAccessFile raf=
			new RandomAccessFile(file, "r");
		//刚刚打开的文件读写指针位置是0
		long p=raf.getFilePointer();
		System.out.println(p);//0
		//读取0位置上的数据(65)
		int b = raf.read();//将byte填充到int
		//占用int： 0~255 范围
		System.out.println(b);//65
		//读取以后，文件指针位置自动移动一下
		//检查文件指针位置
		p = raf.getFilePointer();
		System.out.println(p);//1
		//读取下一个byte数据: 66
		b = raf.read(); 
		System.out.println(b);//66
		//文件指针位置：
		p = raf.getFilePointer();
		System.out.println(p);//2
		//在文件末尾时候调用raf.read()
		//返回一个特殊值：-1 表示读取到文件末尾了
		b = raf.read();
		System.out.println(b);//-1
		p = raf.getFilePointer();
		System.out.println(p);//2
		raf.close();
	}
}










