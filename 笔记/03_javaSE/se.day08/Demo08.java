package day08;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * 将控制台输入的信息保存文本文件中 
 */
public class Demo08 {
	public static void main(String[] args) 
		throws Exception {
		Scanner in = new Scanner(System.in); 
		String file="abc/mail.txt";
		
		File mail = new File(file);
		if(mail.exists()){
			System.out.print(
				"旧文件存在，还要吗(y/n)？");
			String s = in.nextLine();
			if(s.equals("n")){
				if(mail.delete()){
					System.out.println("已经删除");
				}
			}
		}
		
		//true: 表示追加方式写文件
		FileOutputStream fos=
			new FileOutputStream(file, true);
		BufferedOutputStream bos =
			new BufferedOutputStream(fos);
		OutputStreamWriter osw = 
			new OutputStreamWriter(
			bos, "UTF-8");
		PrintWriter out=
			new PrintWriter(osw, true);
		//从控制台读取一行，向文件中写一行
		while(true){
			String str = in.nextLine();
			if(str.equals(":exit")){
				break;
			}
			out.println(str); 
		}
		out.close();
	}
}



