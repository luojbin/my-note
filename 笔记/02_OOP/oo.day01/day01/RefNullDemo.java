package oo.day01;
//引用类型与null的演示
public class RefNullDemo {
	public static void main(String[] args) {
		Cell c = new Cell();
		Cell cc = c; //指向同一个对象
		c.row = 2;
		cc.row = 5;
		System.out.println(c.row); //5
		
		int a = 5;
		int b = a; //赋值
		a = 8;
		System.out.println(b); //5
		
		Cell c1 = new Cell();
		c1.row = 2;
		c1 = null; //空，没有指向任何对象
		c1.row = 3; //NullPointerException空指针异常
		
	}
}














