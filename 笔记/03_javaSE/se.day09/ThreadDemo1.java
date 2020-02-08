package day09;
/**
 * 线程的创建方式之一:
 * 继承Thread并重写run方法
 * @author adminitartor
 *
 */
public class ThreadDemo1 {
	public static void main(String[] args) {
		Thread t1 = new MyThread1();
		Thread t2 = new MyThread2();
		/*
		 * 启动线程使用start方法。
		 * 当start方法调用后，线程纳入到
		 * 线程调度中。run方法在获取CPU时间
		 * 片后自动调用。
		 * 
		 * 线程对于线程调度的工作是不能控制
		 * 的。
		 * 时间片分配给那个线程，时间片的
		 * 长短线程都不可控。线程只能被动的
		 * 被分配时间片。
		 * 线程调度尽可能均匀的将时间片分配
		 * 给每个线程，但不保证"一人一次"的
		 * 分配模式
		 */
		t1.start();
		t2.start();
	
	}
}
/**
 * 第一种创建线程的方式存在两个不足:
 * 1:由于java是单继承的，这就导致不能去继承
 * 其他类，会存在继承冲突问题。
 * 2:由于重写了线程的run方法，这就导致该线程
 * 只会运行run方法中的任务，存在任务与线程
 * 的强耦合关系，不利于线程重用。
 * @author adminitartor
 *
 */
class MyThread1 extends Thread{
	public void run(){
		for(int i=0;i<1000;i++){
			System.out.println("你是谁啊?");
		}
	}
}
class MyThread2 extends Thread{
	public void run(){
		for(int i=0;i<1000;i++){
			System.out.println("我是查水表的!");
		}
	}
}














