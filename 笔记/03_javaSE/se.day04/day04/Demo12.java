package day04;

import java.util.ArrayList;
import java.util.List;

/**
 * List  元素的插入与删除 
 */
public class Demo12 {
	public static void main(String[] args) {
		List<String> list = 
			new ArrayList<String>();
		list.add("Tom");
		list.add("Jerry");
		System.out.println(list);
		//在list集合的头部（0位置）插入元素
		list.add(0, "Wang");
		System.out.println(list); 
		//删除集合最后一个元素,
		//返回值是被删除的元素（元素的引用）
		String name=list.remove(2);
		System.out.println(list); 
		System.out.println(name); 
	} 

}



