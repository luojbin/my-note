package day09;
/**
 * 线程提供的方法:
 * void join()
 * 允许一个现在等待另一个线程工作完毕后再
 * 继续运行。
 * 所以使用join方法可以协调线程间同步运行。
 * 
 * 同步:有先后顺序的运行
 * 异步:各执行各的，互不干扰
 * @author adminitartor
 *
 */
public class Thread_join {
	//图片是否下载完毕 
	private static boolean isFinish = false;
	
	public static void main(String[] args) {
		final Thread download = new Thread(){
			public void run(){
				System.out.println("down:开始下载图片...");
				for(int i=1;i<=100;i++){
					System.out.println("down:"+i+"%");
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("down:图片下载完毕!");
				isFinish = true;
			}
		};
		
		Thread show = new Thread(){
			public void run(){
				System.out.println("show:开始显示图片!");
				/*
				 * 等待图片现在完毕!
				 */
				try {
					//使show线程阻塞，直到download结束
					download.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				
				if(!isFinish){
					throw new RuntimeException("图片加载失败!");
				}
				System.out.println("show:显示图片完毕!");
			}
		};
		
		download.start();
		show.start();
	}
}









