package day09;
/**
 * 线程提供了一个静态方法:
 * static Thread currendThread()
 * 该方法可以获取运行这个方法的线程。
 * @author adminitartor
 *
 */
public class Thread_currentThread {
	public static void main(String[] args) {
		Thread t = Thread.currentThread();
		System.out.println("运行main方法的线程是:"+t);
		
		dosome();	
		Thread my = new Thread(){
			public void run(){
				Thread t = Thread.currentThread();
				System.out.println("自定义线程:"+t);
				dosome();
			}
		};
		my.start();
	}
	
	public static void dosome(){
		//获取运行dosome方法的线程
		Thread t = Thread.currentThread();
		System.out.println("运行dosome方法的线程是:"+t);
	}
}







