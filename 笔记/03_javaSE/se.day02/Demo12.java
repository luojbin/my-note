package day02;

/**
 * 一个有意义的toString重写案例 
 */
public class Demo12 {
	public static void main(String[] args) {
		Airplane a1 = new Airplane(5, 7);
		a1.move();
		a1.move();
		a1.move();
		//System.out.println(a1.x+","+a1.y);
		System.out.println(a1);
		a1.move();
		a1.move();
		a1.move();
		//System.out.println(a1.x+","+a1.y);
		System.out.println(a1);
	}
}
class Airplane{
	int x, y;
	public Airplane(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public void move(){
		x++;
		y+=2;
	}
	//重写toString方法后可以简化调试程序
	//在程序中使用 System.out.println(plane);
	//即可输出对象的数据值
	public String toString() {
		return x+","+y;
	}
}



