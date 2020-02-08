package day07;

import java.io.FileOutputStream;

/**
 * 使用文件输出节点流写文件 
 */
public class Demo06 {
	public static void main(String[] args) 
		throws Exception {
		String file="abc/fos.dat";
		//利用文件节点流打开一个文件
		//当文件不存在时候，会自动创建文件
		//文件存在时候将文件替换为新文件
		//当文件不能写时候，出现异常
		FileOutputStream out = 
			new FileOutputStream(file);
		//测试基本的 byte 数据写出方法
		//将byte写到文件中有效范围（0~255）
		out.write(65);
		out.write(66);
		//关闭文件
		out.close();
	}
}


