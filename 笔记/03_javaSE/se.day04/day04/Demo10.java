package day04;

import java.util.LinkedList;
import java.util.List;

/**
 * 测试 List 的 get 方法和 set方法 
 */
public class Demo10 {
	public static void main(String[] args) {
		List<String> list =
			new LinkedList<String>();
		list.add("Tom");
		list.add("Jerry");
		list.add("Andy");
		System.out.println(list);
		//将集合中序号为0的元素引用复制到str
		String str = list.get(0);
		System.out.println(str);
		str= list.get(1);
		System.out.println(str);
		//置换集合中的元素
		String name = list.set(2, "Wang");
		System.out.println(name);
		System.out.println(list);
	}
}




