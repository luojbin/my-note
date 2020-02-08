package oo.day03;
//super的演示
public class SuperDemo {
	public static void main(String[] args) {
		Boo o = new Boo();
	}
}
class Coo{
	Coo(int a){
	}
}
class Doo extends Coo{
	Doo(){
		super(5);
	}
}









class Aoo{
	Aoo(){
		System.out.println("父类构造方法");
	}
}
class Boo extends Aoo{
	Boo(){
		super(); //默认的
		System.out.println("子类构造方法");
	}
}









