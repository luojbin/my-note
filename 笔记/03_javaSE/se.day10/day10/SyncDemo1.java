package day10;
/**
 * 当多个线程并发操作同一资源时，由于线程
 * 切换时机不确定，导致代码执行顺序出现了
 * 混乱，严重时可能会导致系统瘫痪。
 * 
 * @author adminitartor
 *
 */
public class SyncDemo1 {
	public static void main(String[] args) {
		final Table table = new Table();
		Thread t1 = new Thread(){
			public void run(){
				while(true){
					int bean = table.getBean();
					Thread.yield();//模拟线程发生切换
					System.out.println(getName()+":"+bean);
				}
			}
		};
		Thread t2 = new Thread(){
			public void run(){
				while(true){
					int bean = table.getBean();
					Thread.yield();//模拟线程发生切换
					System.out.println(getName()+":"+bean);
				}
			}
		};
		t1.start();
		t2.start();
		
	}
}

class Table{
	//桌子上有20个豆子
	private int beans = 20;
	/*
	 * 当一个方法被synchronized修饰后
	 * 那么该方法称为同步方法。多个线程
	 * 不能同时访问内部。
	 * 
	 * 在方法上使用synchronized后，同步监视器
	 * 对象为当前方法所属对象，即:this
	 */
	public synchronized int getBean(){
		if(beans==0){
			throw new RuntimeException("没有豆子了!");
		}
		Thread.yield();//模拟线程发生切换
		return beans--;
	}
}








