package day04;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 集合转换为数组 
 */
public class Demo14 {
	public static void main(String[] args) {
		Collection<Integer> col=
			new ArrayList<Integer>();
		col.add(1);
		col.add(2);
		col.add(3);
		col.add(4);
		
		Integer[] ary = new Integer[10];
		for(int i=0; i<ary.length; i++){
			ary[i]=0;
		}
		//将集合col中的引用复制到ary中
		Integer[] a=col.toArray(ary);
		
		for(Integer n:ary){
			System.out.println(n);
		}
		for(Integer n:a){
			System.out.println(n);
		}
	}
}











