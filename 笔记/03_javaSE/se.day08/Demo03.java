package day08;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

/**
 * 对象反序列化 
 */
public class Demo03 {
	public static void main(String[] args)
		throws  Exception{
		String file = "abc/obj.dat";
		
		FileInputStream fis=
			new FileInputStream(file);
		BufferedInputStream bis=
			new BufferedInputStream(fis);
		ObjectInputStream ois=
			new ObjectInputStream(bis);
		//读取对象
		//从文件读取一系列byte数据拼接为对象
		Person p1 = (Person)ois.readObject();
		Person p2 = (Person)ois.readObject();
		System.out.println(p1);
		System.out.println(p2);
		ois.close();
		
	}
}






