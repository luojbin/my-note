package day03;

import java.util.Calendar;

public class Demo14 {
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		//获取年份分量
		int year=cal.get(Calendar.YEAR);
		System.out.println(year); 
		//获取月份分量
		int month = cal.get(Calendar.MONTH);
		System.out.println(month);
		//获取日期分量
		int d = cal.get(Calendar.DATE);
		System.out.println(d); 
		//获取星期
		int w = cal.get(Calendar.DAY_OF_WEEK);;
		System.out.println(w); 
		
	}
}




