package day04;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * 增强for循环（foreach 循环） 
 *
 */
public class Demo09 {
	public static void main(String[] args) {
		Collection<String> c=
				new ArrayList<String>();
		c.add("鸡蛋");
		c.add("鸭蛋");
		c.add("坏蛋");
		c.add("鹅蛋");
		//c.add(0);
		c.add(null);
		//Iterator ite = c.iterator();
		//while(ite.hasNext()){
		//	Object s = ite.next();
		for(String s: c){
			System.out.println(s); 
		}
			
		
	}

}
