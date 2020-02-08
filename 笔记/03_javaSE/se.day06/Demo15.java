package day06;
import java.io.RandomAccessFile;
/**
 * RAF 写出文件 
 */
public class Demo15 {
	public static void main(String[] args) 
		throws Exception{
		String file="abc/demo.txt";
		//创建RAF对象，以读写方式创建对象时候
		//如果文件不存在，则在磁盘上自动创建
		//文件，文件默认的指针位置在0
		//如果文件与文件夹同名或者不能写文件
		//则抛出异常
		RandomAccessFile raf=
			new RandomAccessFile(file, "rw");
		//检查文件的读写指针位置
		long p=raf.getFilePointer();
		System.out.println(p);//0
		//将数据写到文件中
		raf.write(65); //有效范围：0~255
		p = raf.getFilePointer();
		System.out.println(p);
		
		raf.write(66);
		p = raf.getFilePointer();
		System.out.println(p);
		
		long l = raf.length();//检查文件的长度
		System.out.println(l); 
		
		raf.close();//raf必须关闭
	}

}
