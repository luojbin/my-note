package day03;
/**
 * 数字类型包装类型的父类 Number
 * 
 * Number 中定义了 子类的公共方法，
 * 全部子类都继承这些功能
 * Number 可以定义变量引用任何子类型实例
 */
public class Demo04 {
	public static void main(String[] args) {
		Integer i=6;//自动包装
		//将Integer转换为 double类型数据
		double d = i.doubleValue();
		System.out.println(d); //6.0
		//读取整数类型
		int n = i.intValue();
		System.out.println(n);
		//Java5 以后提供了自动拆包
		int m = i;//编译后 i.intValue();
		System.out.println(m); 
		
		Double x = 6.6;
		double y = x.doubleValue();
		int k = x.intValue();
		double z = x;//x.doubleValue();
		System.out.println(x);
		System.out.println(y);
		System.out.println(z);
		System.out.println(k);
		
		Number num = 6.0;
		System.out.println(num);//toString() 
		
	}
}



