package day10;
/**
 * 静态方法使用synchronized修饰后，该方法
 * 一定具有同步效果
 * @author adminitartor
 *
 */
public class SyncDemo3 {
	public static void main(String[] args) {
		Thread t1 = new Thread(){
			public void run(){
				Foo.dosome();
			}
		};
		Thread t2 = new Thread(){
			public void run(){
				Foo.dosome();
			}
		};
		t1.start();
		t2.start();
	}
}

class Foo{
	public synchronized static void dosome(){
		try {
			Thread t = Thread.currentThread();
			System.out.println(t.getName()+":正在运行dosome方法");
			Thread.sleep(5000);
			System.out.println(t.getName()+":运行dosome方法完毕");
		} catch (Exception e) {
			
		}
	}
}






