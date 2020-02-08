package oo.day05;
//final的演示
public class FinalDemo {
	public static void main(String[] args) {
		
	}
}

//演示final修饰类
final class Doo{}
//class Eoo extends Doo{} //编译错误，final的类不可被继承
class Foo{}
final class Goo extends Foo{}



//演示final修饰方法
class Boo{
	void show(){}
	final void test(){}
}
class Coo extends Boo{
	void show(){}
	//void test(){} //编译错误，final的方法不可被重写
}


/*
 * final修饰成员变量，只有两种初始化方式:
 *   1)声明同时初始化
 *   2)在构造方法中初始化
 * final修饰局部变量，只要用之前初始化即可
 */
//演示final修饰变量
class Aoo{ 
	final int num = 5;
	final int count;
	Aoo(){
		count = 6;
	}
	void show(){
		final int n;
		//num = 55; //编译错误，final的变量不可被修改
	}
}
















