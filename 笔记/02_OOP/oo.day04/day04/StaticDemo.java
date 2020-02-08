package oo.day04;
//static的演示
public class StaticDemo {
	public static void main(String[] args) {
		Loo o1 = new Loo();
		o1.show();
		Loo o2 = new Loo();
		o2.show();
		System.out.println(Loo.b); //建议类名点来访问 
		//System.out.println(o1.b); //可以通过引用访问，但不建议
		
		Moo.test();
		
		Noo o3 = new Noo();
		Noo o4 = new Noo();
		Noo o5 = new Noo();
	}
}

class Noo{ //演示静态块
	static{
		System.out.println("静态块");
	}
	Noo(){
		System.out.println("构造方法");
	}
}

class Moo{ //演示静态方法
	int a; //实例变量
	static int b; //静态变量
	void show(){ //实例方法
		System.out.println(a);
		System.out.println(b);
	}
	static void test(){ //静态方法
		//静态方法没有隐式的this传递
		//没有this意味着没有对象
		//而实例成员必须通过对象点来访问
		//所以静态方法中不能直接访问实例成员
		//System.out.println(a); //编译错误
		System.out.println(b);
	}
}

class Loo{ //演示静态变量
	int a; //实例变量
	static int b; //静态变量
	Loo(){
		a++;
		b++;
	}
	void show(){
		System.out.println("a="+a);
		System.out.println("b="+b);
	}
}



















