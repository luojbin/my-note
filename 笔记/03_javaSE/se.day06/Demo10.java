package day06;

import java.io.File;

/**
 * 文件的改名操作
 * 素材： test/abc.txt  没有 test/def.txt
 */
public class Demo10 {
	public static void main(String[] args) {
		File file1=new File("test/abc.txt");
		File file2=new File("test/def.txt");
		//file1 是存在的文件，
		//file2 是一个不存在的文件
		//将file1的名字改名为file2对应的名字
		boolean b = file1.renameTo(file2);
		//改名之后：file1就不存在了（abc.txt）
		//          file2存在(def.txt)
		System.out.println(b);//true
	}
}



