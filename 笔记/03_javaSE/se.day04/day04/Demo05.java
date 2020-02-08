package day04;

import java.util.ArrayList;
import java.util.Collection;

/**
 * contains 方法
 * 
 * 1. 用于检测集合中是否包含指定元素
 * 2. contains 的算法依赖于元素的equals方法
 */
public class Demo05 {
	public static void main(String[] args) {
		Collection col=new ArrayList();
		col.add("Tom");
		col.add("Jerry");
		col.add("Andy");
		System.out.println(col);
		//查找col中是否包含 "Tom" 元素
		//由于String类型实现了equals方法
		//则contains方法可以很正常的工作
		boolean b = col.contains("Tom");
		System.out.println(b);//true
		b = col.contains("Lee");
		System.out.println(b);//false
	}
}






