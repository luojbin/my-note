package day02;

public class Demo11 {
	public static void main(String[] args) {
		Foo foo = new Foo();
		//调用Object提供的默认toString方法
		//返回一个字符串，意义不大
		String str = foo.toString();
		System.out.println(str);
		//调用重写的toString()方法
		Goo goo = new Goo();
		String s = goo.toString();
		System.out.println(s);
		//toString的用途：println 等
		//很多API会自动的调用toString
		//可以简化软件的开发和测试
		System.out.println(goo); 
	}
}
class Foo /*extends Object*/{
}
class Goo{
	//重新继承与Object类的toString();
	public String toString(){
		return "Hello World!";
	}
}



