package day07;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 写员工信息 
 */
public class Demo04 {
	public static void main(String[] args) 
		throws IOException{
		String file="abc/emp.dat";
		RandomAccessFile raf=
			new RandomAccessFile(file, "rw");
		write(raf, 0,"Tom", 10, "男", 100, new Date());
		write(raf, 1,"范传奇",30,"男",200,new Date());
		raf.close();
	}	
	public static void write(
			RandomAccessFile raf, //已经打开的文件
			int n, //n = 0 1 2 ... 行号
			String name, 
			int age,
			String sex,
			int salary,
			Date hiredate)throws IOException{
		int start=n*80;//n=0,0  n=1,80  n=2,160
		raf.seek(start);//将文件指针移动到每行起始位置
		//将name编码，然后写到文件中
		byte[] bytes=name.getBytes("UTF-8");
		raf.write(bytes); //3 9 10
		//写出age
		raf.seek(start+32);//跳到age位置
		raf.writeInt(age);//写出年龄
		//写出性别
		bytes = sex.getBytes("UTF-8");
		raf.write(bytes);
		//写出薪水
		raf.seek(start+46);
		raf.writeInt(salary); 
		//写出日期
		SimpleDateFormat fmt = 
				new SimpleDateFormat("yyyy-MM-dd");
		String d = fmt.format(hiredate);
		bytes = d.getBytes("UTF-8");
		raf.write(bytes);
	}
}



