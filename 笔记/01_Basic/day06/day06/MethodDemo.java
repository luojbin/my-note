package day06;
//方法的演示
public class MethodDemo {
	public static void main(String[] args) {
		//say();
		
		/*
		//sayHi(); //编译错误，有参必须传参
		//sayHi(25); //编译错误，参数类型必须匹配
		sayHi("zhangsan"); //String name="zhangsan"
		sayHi("lisi"); //String name="lisi"
		sayHi("wangwu");
		sayHi("zhaoliu");
		*/
		
		/*
		int a = getNum(); //getNum()的值就是return后的值
		System.out.println(a); //88
		*/
		
		/*
		double num = plus(5.0,6.6);
		System.out.println(num); //11.6
		*/
		
		//a(); //演示方法的嵌套调用
		
		double m=5.0,n=6.6;
		double s = plus(m,n); //double a=5.0,double b=6.6
		System.out.println(s);
		
		System.out.println("over");
	}
	
	//有参有返回值
	public static double plus(double a,double b){
		double c = a+b;
		return c; //返回的是c里面的那个数
		//return a+b;
	}
	
	//无参有返回值
	public static int getNum(){
		//return; //编译错误，必须跟一个值
		//return 8.88; //编译错误，返回值类型不匹配
		return 88; //1)结束方法的执行  2)返回结果给调用方
	}
	
	//有参无返回值
	public static void sayHi(String name){
		System.out.println("大家好，我叫"+name);
		return; //结束方法的执行
	}
	
	//无参无返回值
	public static void say(){
		System.out.println("大家好，我叫WKJ");
	}
	
	public static void a(){
		System.out.println(111);
		b();
		System.out.println(222);
	}
	public static void b(){
		System.out.println(333);
	}
}









