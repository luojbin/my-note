package day10;
/**
 * 有效的缩小同步范围可以在保证并发安全的
 * 前提下提高并发效率
 * 
 * 同步块可以更精确的锁定需要同步执行的
 * 代码片段。
 * @author adminitartor
 *
 */
public class SyncDemo2 {
	public static void main(String[] args) {
		final Shop shop = new Shop();
		Thread t1 = new Thread(){
			public void run(){
				shop.buy();
			}
		};
		Thread t2 = new Thread(){
			public void run(){
				shop.buy();
			}
		};
		t1.start();
		t2.start();
		
	}
}

class Shop{
	public void buy(){
		try {
			Thread t = Thread.currentThread();
			System.out.println(t.getName()+":正在挑选衣服...");
			Thread.sleep(5000);
			/*
			 * 同步块
			 * synchronized(同步监视器对象){
			 * 	 需要同步的代码片段
			 * }
			 * 同步块可以更准确的指定需要同步
			 * 执行的代码片段。但是需要注意的
			 * 是多个线程之间若需要同步执行该
			 * 端代码，看到的同步监视器对象
			 * 必须是同一个!
			 * 
			 */
			synchronized (this) {
				System.out.println(t.getName()+":正在试衣服...");
				Thread.sleep(5000);
			}
			
			
			System.out.println(t.getName()+":结账离开");	
		} catch (Exception e) {			
		}
	}
}











