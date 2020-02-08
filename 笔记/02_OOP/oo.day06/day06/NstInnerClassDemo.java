package oo.day06;
//匿名内部类的演示
public class NstInnerClassDemo {
	public static void main(String[] args) {
		//1)创建了Inter2的一个子类，但是没有名字
		//2)为该子类创建了一个对象，叫o1
		//3)大括号中的为子类的类体
		Inter2 o1 = new Inter2(){	
		};
		
		//1)创建了Inter2的一个子类，但是没有名字
		//2)为该子类创建了一个对象，叫o2
		//3)大括号中的为子类的类体
		Inter2 o2 = new Inter2(){
		};
		
		final int num = 5;
		Inter3 o3 = new Inter3(){
			public void show(){
				System.out.println("showshow");
				System.out.println(num);
			}
		};
		o3.show();
		
	}
}

interface Inter3{
	void show();
}

interface Inter2{
}













