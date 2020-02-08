package day04;

import java.util.Arrays;

/**
 * 数组持有的是对象的引用，也称为引用数组
 * 就是保存引用的数组！！ 
 */
public class Demo02 {
	public static void main(String[] args) {
		Person[] ary = new Person[3];
		ary[0] = new Person("Tom", 5);
		ary[1] = new Person("Jerry", 6);
		for(int i=0; i<ary.length; i++){
			System.out.print(ary[i]+" ");
		}
	}
}
class Person{
	int age;
	String name;
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public String toString(){
		return "("+name+","+age+")";
	}
}




