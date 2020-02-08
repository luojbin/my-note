package day10;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池
 * 主要作用:
 * 1:控制线程数量
 * 2:重用线程
 * @author adminitartor
 *
 */
public class ThreadPoolDemo {
	public static void main(String[] args) {
		ExecutorService threadPool
			= Executors.newFixedThreadPool(2);
		
		for(int i=0;i<5;i++){
			Runnable runn = new Runnable(){
				public void run(){
					try {
						Thread t = Thread.currentThread();
						System.out.println(
							t.getName()+":正在执行任务");
						Thread.sleep(5000);
						System.out.println(
							t.getName()+":运行任务完毕");	
					} catch (Exception e) {
						System.out.println("线程被中断了!");
					}
				}
			};
			threadPool.execute(runn);
			System.out.println("指派了一个任务");
		}
		
		threadPool.shutdownNow();
		System.out.println("停止了线程池!");
	}
}








