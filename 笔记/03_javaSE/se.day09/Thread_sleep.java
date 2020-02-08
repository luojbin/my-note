package day09;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 线程提供了方法:
 * static void sleep(long ms)
 * 该方法会导致运行该方法的线程阻塞指定毫秒
 * 超时以后该线程会自动回到RUNNABLE状态等待
 * 再次获取CPU时间并发运行
 * 常用sleep方法做定时或周期间隔时间使用
 * @author adminitartor
 *
 */
public class Thread_sleep {
	public static void main(String[] args) {
		/*
		 * 电子表功能
		 * 每秒钟输出当前系统时间:
		 * 15:25:32
		 */
		SimpleDateFormat sdf
			= new SimpleDateFormat("HH:mm:ss");
		while(true){
			try {
				System.out.println(
					sdf.format(new Date())
				);
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}







