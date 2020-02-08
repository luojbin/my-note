package day04;

import java.util.ArrayList;
import java.util.List;

/**
 * List 的 subList  
 * subList 与原有List共享相同的存储空间
 */
public class Demo13 {
	public static void main(String[] args) {
		List<String> list =
			new ArrayList<String>();
		for(int i = 3; i<=10; i++ ){
			list.add("黑桃"+i);
		}
		System.out.println(list);
		//从list的3位置开始抽取3个元素为sub List 
		List<String> sub=list.subList(3,3+3);
		System.out.println(sub);
		//由于共享存储空间，
		//修改subList影响原list集合
		sub.remove(0);
		System.out.println(sub);
		System.out.println(list);
		
		
	}

}





