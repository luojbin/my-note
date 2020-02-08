package day08;

import java.util.ArrayList;
import java.util.List;

/**
 * 系统不可恢复的错误：堆内存溢出（内存泄漏） 
 */
public class Demo10 {
	public static void main(String[] args) {
		List<Foo> list= 
			new ArrayList<Foo>();
		for(int i=0; i<50000000; i++){
			list.add(new Foo());
			//new Foo();
		}
	}
}
class Foo{
	long a;
	long b;
	long c;
	long d;
}




