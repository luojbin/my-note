package day03;

import java.util.Date;
/**
 * Date 类型 
 * 
 * 1. 默认的Date类型对象中封装当前系统时间毫秒
 * 2. getTime 获取时间毫秒数 
 * 3. 修改date中的毫秒数
 * 4. Date 重写了toString 方法
 */
public class Demo08 {
	public static void main(String[] args) {
		//默认的Date类型中封装了系统时间毫秒
		Date date = new Date();
		//获取时间毫秒数
		long now = date.getTime();
		System.out.println(now);
		long y=now/1000/60/60/24/365 + 1970;
		System.out.println(y); 
		//date 重写了toString();
		System.out.println(date); 
		
		int year = date.getYear();
		System.out.println(year); 
		//修改date中的毫秒数
		//0毫秒代表 GTM 时间的1970年元旦
		date.setTime(-1000L*60*60*24);
		System.out.println(date); 
		year = date.getYear();
		System.out.println(year); 
	}
}




