package day05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 对可以比较大小的对象进行自然排序 
 */
public class Demo02 {
	public static void main(String[] args) {
		List<String> list = 
				new ArrayList<String>();
		list.add("Tom");
		list.add("Jerry");
		list.add("Andy");
		list.add("Lee");
		list.add("Mac");
		/*
		 * sort方法只能对List集合进行排序
		 * list集合中的元素需要实现Compatible
		 * 接口包含compareTo方法 
		 */
		Collections.sort(list);
		System.out.println(list); 
		
	}
}
