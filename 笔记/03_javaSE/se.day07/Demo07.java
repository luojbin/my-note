package day07;

import java.io.FileInputStream;
/**
 * 测试 文件输入节点流 的读取文件
 */
public class Demo07 {
	public static void main(String[] args) 
		throws Exception {
		String file="abc/fos.dat";
		//用文件节点输入流打开文件
		//如果文件不能打开或者文件不存在
		//就抛出异常！
		FileInputStream in = 
			new FileInputStream(file);
		//测试基本的节点流读取方法
		//每次从文件中读取一个byte(0~255)
		int b1 = in.read();
		int b2 = in.read();
		System.out.println(b1);
		System.out.println(b2);
		in.close();
	}
}




