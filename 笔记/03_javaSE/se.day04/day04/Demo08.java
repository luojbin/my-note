package day04;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * 集合的迭代 
 */
public class Demo08 {
	public static void main(String[] args) {
		Collection c=new ArrayList();
		c.add("鸡蛋");
		c.add("鸭蛋");
		c.add("坏蛋");
		c.add("鹅蛋");
		c.add(null);
		//遍历一个集合
		Iterator ite = c.iterator();
		//检查ite当前游标是否有下一个元素引用
		while(ite.hasNext()){
			//移动游标取出下一个元素的引用
			String s = (String)ite.next();
			System.out.println(s);
			if("坏蛋".equals(s)){
				//将元素从原集合中删除
				ite.remove();
			}
		}
		System.out.println(c);
	}
}








