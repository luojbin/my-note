package day06;
import java.io.File;
import java.io.FileFilter;
/**
 * 设置文件的过滤条件
 * File： 文件
 * Filter: 过滤器
 */
public class Demo14 {
	public static void main(String[] args) {
		//FileFilter 是一个接口
		//new FileFilter(){} 创建匿名内部类
		FileFilter filter = 
			new FileFilter(){
			//accept 方法是在FileFilter中定义
			//的抽象方法。
			//accept: 接受，测试文件是否
			//被接受
			public boolean accept(File file){
				//接受一个文件的名是以.txt
				//为结尾的。
				String name=file.getName();
				return name.endsWith(".txt"); 
			}
		};
		
		File file1 = new File("abc/demo1.txt");
		File file2 = new File("abc/test.dat");
		//检查 file1 使用以 .txt 为结尾
		System.out.println(
				filter.accept(file1));//true
		//检查 file2 使用以 .txt 为结尾
		System.out.println(
				filter.accept(file2));//false
		
		//listFiles 重载方法，与filter配合
		//可以过滤文件夹内容列表，列出满足
		//条件的文件
		
		File dir=new File("abc");
		//满足过滤条件的全部文件（或文件夹）
		File[] files=dir.listFiles(filter);
		for(File file:files){
			System.out.println(file.getName());
		}
		//有过滤条件的列目录方法
		//listFiles(过滤条件);
	}
}








