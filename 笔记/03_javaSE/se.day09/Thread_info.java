package day09;
/**
 * 获取线程相关信息的一系列方法
 * @author adminitartor
 *
 */
public class Thread_info {
	public static void main(String[] args) {
		//获取运行main方法的线程
		Thread main = Thread.currentThread();
		
		//获取id
		long id = main.getId();
		System.out.println("id:"+id);
		
		//获取名字
		String name = main.getName();
		System.out.println("name:"+name);
		
		//获取线程优先级
		int priority = main.getPriority();
		System.out.println("priority:"+priority);
		
		boolean isAlive = main.isAlive();
		System.out.println("isAlive:"+isAlive);
		
		boolean isDaemon = main.isDaemon();
		System.out.println("isDaemon:"+isDaemon);
		
		boolean isInterrupted = main.isInterrupted();
		System.out.println("isInterrupted:"+isInterrupted);
	}
}







