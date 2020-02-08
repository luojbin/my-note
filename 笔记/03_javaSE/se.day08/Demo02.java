package day08;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

/**
 * 对象输出流 
 */
public class Demo02 {
	public static void main(String[] args) 
		throws Exception{
		Person p1 = new Person("范传奇", 10);
		Person p2 = new Person("李洪鹤", 10);
		p1.friend = p2;
		String file="abc/obj.dat";
		//将对象写到文件中
		FileOutputStream fos=
			new FileOutputStream(file);
		BufferedOutputStream bos=
			new BufferedOutputStream(fos);
		//对象输出流
		ObjectOutputStream oos=
			new ObjectOutputStream(bos);
		//将对象写到文件中
		oos.writeObject(p1);
		oos.writeObject(p2);
		//关闭高级流就会自动关闭全部流
		oos.close();		
	}
}






