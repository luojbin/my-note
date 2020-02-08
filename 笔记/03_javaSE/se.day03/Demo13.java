package day03;

import java.util.Calendar;

/**
 * 设置时间的分量 
 */
public class Demo13 {
	public static void main(String[] args) {
		//默认的Calender是当前时间
		Calendar cal=Calendar.getInstance();
		System.out.println(cal.getTime());
		//利用set方法修改时间分量：
		//修改年份分量
		cal.set(Calendar.YEAR, 2000);
		//修改月份分量
		cal.set(Calendar.MONTH, 
				Calendar.AUGUST);
		//修改日期分量
		cal.set(Calendar.DATE, 1);
		//检查修改的结果：
		System.out.println(cal.getTime());
 		
		//超量更改时间：32天是一个月多一天
		cal.set(Calendar.DATE, 32);
		System.out.println(cal.getTime());
			
	}
}







