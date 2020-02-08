package day06;

import java.io.File;

/**
 * 删除一个包含文件的文件夹 
 */
public class Demo12 {
	public static void main(String[] args) {
		File file = new File("abc");
		boolean b=delete(file);
		System.out.println(b); 
	}
	// 删除一个包含文件的文件夹 
	public static boolean delete(File dir){
		//删除一个文件夹的步骤：
		//1. 列出文件夹的全部内容
		//2. 遍历每个文件，并且调用文件的detete()
		//3. 删除文件夹
		//4. 返回删除的结果
		if(! dir.exists()){
			return false;
		}
		File[] files=dir.listFiles();
		for(File file:files){
			if(file.isDirectory()){
				//删除子文件夹
				//删除子文件的算法与删除当前
				//文件夹的算法是一致的。利用
				//递归删除子文件夹
				delete(file);
			}else{
				file.delete();
			}
		}
		return dir.delete();
	}
}




