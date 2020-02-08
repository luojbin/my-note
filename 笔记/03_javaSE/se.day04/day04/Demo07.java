package day04;

import java.net.StandardSocketOptions;
import java.util.Collection;
import java.util.HashSet;

/**
 * 集合的合并和集合的包含
 */
public class Demo07 {
	public static void main(String[] args) {
		Collection c1 = new HashSet();
		Collection c2 = new HashSet();
		
		c1.add("Tom");
		c1.add("Jerry");

		c2.add("Andy");
		c2.add("John");
		
		System.out.println(c1);
		System.out.println(c2);
		//检查 c1是否包含c2 中的全部元素吗？
		System.out.println(c1.containsAll(c2));
		//将c2的元素添加到c1中，添加成功为true
		boolean b = c1.addAll(c2);
		System.out.println(b);
		System.out.println(c1);
		System.out.println(c2);
		//添加不成功返回false
		b = c1.addAll(c2);
		System.out.println(b);
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c1.containsAll(c2));
	}
}






