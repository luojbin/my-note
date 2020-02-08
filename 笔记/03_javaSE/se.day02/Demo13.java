package day02;

public class Demo13 {
	public static void main(String[] args) {
		Point p1 = new Point(3, 4);
		Point p2 = new Point(5, 6);
		Point p3 = new Point(3, 4);
		Point p4 = p1;
		//p1和p3引用的对象逻辑上是相等的！
		//但是==比较不能反映这个“相等”结果
		//== 只能用于比较两个变量相等
		//不能用于比较两个对象是否相等
		System.out.println(p1==p3);//false
		System.out.println(p1==p4);//true
		
		//默认的equals方法也不能对象相等
		//必须重新才行！！！
		System.out.println(p1.equals(p3));
		System.out.println(p1.equals(p4));
		PointX p5 = new PointX(3, 4);
		PointX p6 = new PointX(3, 4);
			
		System.out.println(p5.equals(p6));//true 
		System.out.println(p5.equals(null)); 
	}
}
class Point{
	int x, y;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public String toString() {
		return x+","+y;
	}
}
class PointX{
	int x, y;
	public PointX(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public String toString() {
		return x+","+y;
	}
	//重写equals方法比较两个对象是否相等
	public boolean equals(Object obj){
		//当两个对象的x和y都相等时候则相等
		if(obj==null) return false;
		if(this==obj) return true;
		//使用if语句保护，避免造型异常
		if(obj instanceof PointX){
			//为了读取x y属性必须造型为子类型
			PointX other=(PointX)obj;
			return this.x == other.x && 
				this.y == other.y;
		}
		//方法一定返回一个boolean值！
		return false;
	}
}



