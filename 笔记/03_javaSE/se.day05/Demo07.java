package day05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ArrayList 顺序查找和 HashMap散列查找的性能差别
 * list.indexOf(obj)：在list顺序查找obj对象
 * 返回对象的索引位置
 *    
 * map.get(key) 是散列查找
 */
public class Demo07 {
	public static void main(String[] args) {
		List<Integer> list= 
			new ArrayList<Integer>();
		Map<Integer, Integer> map =
			new HashMap<Integer, Integer>();
		for(int i=0; i<800000; i++){
			list.add(i);
			map.put(i, i);
		}
		long t1 = System.nanoTime();
		int idx = list.indexOf(799999);
		long t2 = System.nanoTime();
		int n = map.get(799999);
		long t3 = System.nanoTime();
		System.out.println(idx);//99999
		System.out.println(n);
		System.out.println(
				(t2-t1)+","+(t3-t2));
	}
}







