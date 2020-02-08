package day10;
/**
 * 互斥锁
 * 当synchronized修饰的是两段不同的代码
 * 但是锁对象相同时，那么这两端代码就是
 * 互斥的。
 * @author adminitartor
 *
 */
public class SyncDemo4 {
	public static void main(String[] args) {
		final Boo b = new Boo();
		Thread t1 = new Thread(){
			public void run(){
				b.methodA();
			}
		};
		Thread t2 = new Thread(){
			public void run(){
				b.methodB();
			}
		};
		t1.start();
		t2.start();
	}
}

class Boo{
	public void methodA(){
		synchronized(this){
			try {
				Thread t = Thread.currentThread();
				System.out.println(
					t.getName()+":正在运行A方法");
				Thread.sleep(5000);
				System.out.println(
					t.getName()+":运行A方法完毕");
			} catch (Exception e) {			
			}
		}
	}
	public void methodB(){
		synchronized(this){
			try {
				Thread t = Thread.currentThread();
				System.out.println(t.getName()+":正在运行B方法");
				Thread.sleep(5000);
				System.out.println(t.getName()+":运行B方法完毕");
			} catch (Exception e) {			
			}
		}
	}
}







