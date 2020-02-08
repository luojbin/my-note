package day06;

import java.io.File;

/**
 * 统计一个文件夹中全部文件的总长度 
 */
public class Demo13 {
	public static void main(String[] args) {
		File dir = new File("abc");
		long n = count(dir);
		System.out.println(n); 
	}
	//统计dir对应的文件夹中文件的总大小
	public static long count(File dir){
		//1. 查找dir的全部内容
		//2. 遍历每个文件，累加文件的大小
		//3. 返回统计结果
		if(! dir.exists()){	return 0;}
		if(dir.isFile()){return dir.length();}
		File[] files=dir.listFiles();
		long sum = 0;
		for(File file:files){
			if(file.isDirectory()){
				//统计子文件夹的总大小:
				//统计子文件夹时候和统计当前
				//文件夹的算法是一样的！
				long l = count(file);
				sum += l;
			}else{
				//统计一个文件
				sum+=file.length();	
			}
		}
		return sum;
	}
}


