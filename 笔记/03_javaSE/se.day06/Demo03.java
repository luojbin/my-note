package day06;

import java.io.File;

/**
 * 文件分隔符问题：
 * 1. Windows 的文件分隔符 ：\
 * 	  - D:\demo\test.txt
 *    - demo\test.txt
 *    - File.separator = \
 * 2. Linux 的文件分隔符 ：/
 *	  - /home/soft01/demo/test.txt
 *    - demo/test.txt
 *    - File.separator = /
 * 3. File 类提供了自动适应操作系统的文件分隔符
 * 变量File.separator或随着操作系统自动变化，
 * 可以利用这变量，编写跨系统的程序：
 * 	  - "demo"+File.separator+"test.txt"
 * 4. 当使用 “/” 时候 Java 会自动使用所有操作
 *    系统，这样更加方便！
 */
public class Demo03 {
	public static void main(String[] args) {
		String path= "demo"+File.separator+
				"test.txt";
		File file = new File(path);
		boolean b = file.exists();
		System.out.println(b);//false
	}
}
