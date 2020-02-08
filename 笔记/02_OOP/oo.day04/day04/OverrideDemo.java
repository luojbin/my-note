package oo.day04;
//重写的演示
public class OverrideDemo {
	public static void main(String[] args) {
		Aoo o1 = new Aoo();
		o1.show(); //父类show
		
		Boo o2 = new Boo();
		o2.show(); //子类show
		Aoo o3 = new Boo(); //向上造型
		o3.show(); //子类show
	}
}

/*
 * 重写要遵循"两同两小一大"原则:
 * 1.两同:
 *   1)方法名相同
 *   2)参数列表相同
 * 2.两小:
 *   1)子类方法的返回值类型小于或等于父类的
 *     1.1)void时，必须相同
 *     1.2)基本类型时，必须相同
 *     1.3)引用类型时，小于或等于
 *   2)子类方法抛出的异常小于或等于父类的-----异常之后
 * 3.一大:
 *   1)子类方法的访问权限大于或等于父类的-----访问控制修饰符之后
 */
//父类大，子类小
class Coo{
	void show(){}
	double say(){return 0.0;}
	Doo sayHi(){return null;}
	Coo test(){return null;}
}
class Doo extends Coo{
	//int show(){return 1;} //编译错误，void时必须相同
	//int say(){return 0;} //编译错误，基本类型时必须相同
	//Coo sayHi(){return null;} //编译错误，引用类型必须小于或等于
	public Coo test(){return null;} //正确，小于或等于
}









class Aoo{
	void show(){
		System.out.println("父类show");
	}
}
class Boo extends Aoo{
	void show(){
		System.out.println("子类show");
	}
}















