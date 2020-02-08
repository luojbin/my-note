package day04;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 集合中持有的也是对象的引用 
 */
public class Demo03 {
	public static void main(String[] args) {
		Person p = new Person("Tom", 6);
		Collection col = new ArrayList();
		col.add(p);
		col.add(new Person("Jerry", 7));
		System.out.println(col);
		System.out.println(p);
		p.age++;
		System.out.println(col); 
	}
}






