package oo.day06;
//成员内部类的演示
public class InnerClassDemo {
	public static void main(String[] args) {
		Mama m = new Mama();
		//Baby b = new Baby(); //编译错误
	}
}

class Mama{
	private String name;
	Baby createBaby(){
		return new Baby();
	}
	class Baby{
		void showMamaName(){
			System.out.println(name);
			System.out.println(Mama.this.name);
			//System.out.println(this.name); //编译错误
		}
	}
}














