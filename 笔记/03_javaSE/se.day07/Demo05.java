package day07;

import java.io.RandomAccessFile;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 读取员工信息文件 
 *
 */
public class Demo05 {
	public static void main(String[] args) 
		throws  Exception {
		String file="abc/emp.dat";
		//打开文件 emp.dat
		RandomAccessFile raf=
			new RandomAccessFile(file, "r");
		//读取第一行 （Tom）
		Emp e1 = read(raf, 0);
		//读取第二行 （范传奇）
		Emp e2 = read(raf, 1);
		//显示读取结果
		System.out.println(e1);
		System.out.println(e2);
		//关闭文件
		raf.close();
	}
	public static Emp read(
		RandomAccessFile raf, int n) 
		throws Exception {	
		int start = n*80;//读取的起始位置
		raf.seek(start);//找到name的起始位置
		byte[] bytes = new byte[32];
		raf.read(bytes);//读取32个byte
		//bytes=[T,o,m,0,0,0,0,0,...0]
		String name=
			new String(bytes,"UTF-8").trim();
		//读取年龄
		int age = raf.readInt();
		//读取性别...
		bytes = new byte[10];
		raf.read(bytes);
		String sex=new String(bytes,"UTF-8").trim();
		//读取薪水
		int salary = raf.readInt();
		//读取日期
		bytes = new byte[30];
		raf.read(bytes);
		String str = new String(bytes, "UTF-8").trim();
		//解析日期
		SimpleDateFormat fmt = 
			new SimpleDateFormat("yyyy-MM-dd");
		Date hiredate=fmt.parse(str);
		return new Emp(
			name,age,sex,salary,hiredate);
	}
}
class Emp{
	String name;
	int age;
	String sex;
	int salary;
	Date hiredate;
	public Emp(String name, int age, String sex, int salary, Date hiredate) {
		super();
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.salary = salary;
		this.hiredate = hiredate;
	}
	public String toString() {
		return "Emp [name=" + name + ", age=" + age + ", sex=" + sex + ", salary=" + salary + ", hiredate=" + hiredate
				+ "]";
	}
	
}




