package day09;
/**
 * 线程优先级
 * 线程有10个优先级，分别用数字1-10表示
 * 其中1为最低优先级，5为默认优先级，
 * 10为最高优先级
 * 理论上优先级越高的线程获取CPU时间片的次数
 * 就越多。
 * @author adminitartor
 *
 */
public class Thread_setPriority {
	public static void main(String[] args) {
		Thread max = new Thread(){
			public void run(){
				for(int i=0;i<10000;i++){
					System.out.println("max");
				}
			}
		};
		Thread nor = new Thread(){
			public void run(){
				for(int i=0;i<10000;i++){
					System.out.println("nor");
				}
			}
		};
		Thread min = new Thread(){
			public void run(){
				for(int i=0;i<10000;i++){
					System.out.println("min");
				}
			}
		};
		//Thread.MIN_PRIORITY
		min.setPriority(Thread.MIN_PRIORITY);		
		max.setPriority(Thread.MAX_PRIORITY);
		min.start();
		nor.start();
		max.start();
	}
}








