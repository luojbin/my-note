package day04;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 如果元素不正确重写equals，则contains
 * 会失效
 */
public class Demo06 {
	public static void main(String[] args) {
		Collection col=new ArrayList();
		col.add(new Person("Tom", 5));
		col.add(new Person("Jerry", 4));
		col.add(new Person("Andy", 5));
		System.out.println(col);
		Person p=new Person("Tom", 5);
		System.out.println(p);
		/*
		 * 集合元素类型Person上没有很好的
		 * 重写equals造成contains方法的失效！
		 */
		boolean b=col.contains(p);
		System.out.println(b); 
		
		Collection c = new ArrayList();
		c.add(new User("Tom", 1));
		c.add(new User("Jerry", 2));
		c.add(new User("Andy", 3));
		System.out.println(c);
		User user = new User("Tom", 1);
		/*
		 * 集合中的元素类型User很好重写了
		 * equals，保证了contains方法的正确
		 * 执行： 
		 */
		b = c.contains(user);
		System.out.println(b);
		
		System.out.println(c.size()); //3
		System.out.println(c.isEmpty());//flase
		c.clear();//清空集合中的引用
		System.out.println(c.size()); //0
		System.out.println(c.isEmpty());//true
		
	}
	
	
}

class User{
	int id;
	String name;
	public User(String name, int id) {
		this.id=id;
		this.name = name;
	}
	public boolean equals(Object obj){
		if(obj==null) return false;
		if(this==obj) return true;
		if(obj instanceof User){
			User other = (User)obj;
			return id == other.id;
		}
		return false;
	}
	public String toString() {
		return "("+name+","+id+")";
	}
}









