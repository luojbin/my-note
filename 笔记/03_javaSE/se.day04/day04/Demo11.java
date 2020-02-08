package day04;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/**
 * ArrayList 与 LinkedList 性能对比测试 
 */
public class Demo11 {
	public static void main(String[] args) {
		List<Integer> list1 = 
				new ArrayList<Integer>();
		List<Integer> list2 = 
				new LinkedList<Integer>();
		for(int i=0; i<100000; i++){
			list1.add(i);
			list2.add(i);
		}
		long t1=System.nanoTime();
		Integer n1 = list1.get(0);
		long t2=System.nanoTime();
		Integer n2 = list1.get(50000);
		long t3=System.nanoTime();
		Integer n3 = list1.get(99999);
		long t4=System.nanoTime();
		System.out.println(
			(t2-t1)+","+(t3-t2)+","+(t4-t3));
		
		t1=System.nanoTime();
		n1 = list2.get(0);
		t2=System.nanoTime();
		n2 = list2.get(50000);
		t3=System.nanoTime();
		n3 = list2.get(99999);
		t4=System.nanoTime();
		System.out.println(
			(t2-t1)+","+(t3-t2)+","+(t4-t3));

	}
}





