package day10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 线程安全的集合与Map
 * @author adminitartor
 *
 */
public class SyncAPIDemo {
	public static void main(String[] args) {
		/*
		 * ArrayList与LinkedList都不是线程
		 * 安全的
		 */
		List<String> list
			= new ArrayList<String>();
		list.add("one");
		list.add("two");
		list.add("three");
		list.add("four");
		System.out.println(list);
		//将给定的List集合转换为线程安全的
		list = Collections.synchronizedList(list);
		System.out.println(list);
		
		/*
		 * HashSet不是线程安全的
		 */
		Set<String> set 
			= new HashSet<String>(list);
		System.out.println(set);
		set = Collections.synchronizedSet(set);
		System.out.println(set);
		
		/*
		 * HashMap不是线程安全的
		 */
		Map<String,Integer> map
			= new HashMap<String,Integer>();
		map.put("语文", 99);
		map.put("数学", 98);
		map.put("英语", 97);
		System.out.println(map);
		//转换为线程安全的Map
		map = Collections.synchronizedMap(map);
		System.out.println(map);
		
		/*
		 * 集合的元素操作方法不与迭代互斥。
		 * 所以若多线程操作时，并发迭代与增删
		 * 元素间不同步，这可能导致迭代出错。
		 * 所以需要自行维护互斥关系。
		 */
	}
}











