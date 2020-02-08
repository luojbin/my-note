package oo.day05;
//接口的演示
public class InterfaceDemo {
	public static void main(String[] args) {
		Inter6 o1 = new Moo(); //向上造型
		Inter5 o2 = new Moo(); //向上造型
		/*
		 * 接口的练习:
		 * 1.声明接口Inter1，包含常量PI和抽象方法show()
		 * 2.声明接口Inter2，包含a()和b()
		 *   声明类Joo，实现Inter2
		 * 3.声明接口Inter3，包含c()
		 *   声明类Koo，实现Inter2和Inter3
		 * 4.声明抽象类Loo，包含抽象方法d()
		 *   声明类Moo，继承Loo，并实现Inter2和Inter3
		 * 5.声明接口Inter4，继承Inter3，包含e()
		 *   声明类Noo，实现接口Inter4
		 * 6.在main()方法中:
		 *     Inter4 o1 = new Inter4();---------???
		 *     Inter4 o2 = new Noo();------------???
		 *     Inter3 o3 = new Noo();------------???
		 */
	}	
}


//演示接口继承接口
interface Inter5{
	void show();
}
interface Inter6 extends Inter5{
	void say();
}
class Moo implements Inter6{
	public void say(){}
	public void show(){}
}



//演示又继承又实现多个接口
interface Inter3{
	void show();
}
interface Inter4{
	void test();
}
abstract class Koo{
	abstract void say();
}
class Loo extends Koo implements Inter3,Inter4{
	public void show(){}
	public void test(){}
	void say(){}
}




//演示接口的实现
interface Inter2{
	void show();
	void say();
}
class Joo implements Inter2{
	public void show(){}
	public void say(){}
}








//演示接口的语法
interface Inter1{
	public static final int NUM = 5;
	public abstract void show();
	int COUNT = 6; //默认public static final
	void test(); //默认public abstract
	//int NUMBER; //编译错误，常量必须声明同时初始化
	//void say(){} //编译错误，抽象方法不能有方法体
}


















