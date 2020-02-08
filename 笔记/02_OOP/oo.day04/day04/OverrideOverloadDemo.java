package oo.day04;
//重写与重载的区别
public class OverrideOverloadDemo {
	public static void main(String[] args) {
		//重载看引用，重写看对象
		Goo goo = new Goo();
		Eoo o = new Foo(); //向上造型
		goo.test(o); //重载看引用----Eoo
		
	}
}

class Goo{
	void test(Eoo o){
		System.out.println("父型参数");
		o.show(); //重写看对象----Foo
	}
	void test(Foo o){
		System.out.println("子型参数");
		o.show();
	}
}

class Eoo{
	void show(){
		System.out.println("父类show");
	}
}
class Foo extends Eoo{
	void show(){
		System.out.println("子类show");
	}
}

















