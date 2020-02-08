package day04;

import java.net.CookieHandler;
import java.util.Collection; 
import java.util.HashSet; 

/**
 * 集合的添加方法 add
 * 
 * 1. 如果添加成功返回 true
 * 2. 添加失败返回false
 */
public class Demo04 {
	public static void main(String[] args) {
		//HashSet实现了Collection接口
		Collection col=new HashSet();
		boolean b = col.add("Tom");
		System.out.println(b);//true
		b = col.add("Jerry");
		System.out.println(b);
		//重复添加 Tom 结果是false，添加失败
		b = col.add("Tom");
		System.out.println(b);//false
		//Set类型的集合不能存在重复的元素
		System.out.println(col); 
	}

}




