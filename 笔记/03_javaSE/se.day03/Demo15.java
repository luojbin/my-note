package day03;

import java.util.Calendar;
/**
 * 获取当前月的最大日期值 
 */
public class Demo15 {
	public static void main(String[] args) {
		Calendar cal=Calendar.getInstance();
		
		cal.set(Calendar.MONTH, 0);
		System.out.println(cal.getTime());
		//Actual 实际 Maximum最大
		//获取cal中当前月的最大日期值
		int n = cal.getActualMaximum(
			Calendar.DAY_OF_MONTH);
		System.out.println(n); 
		System.out.println(cal.getTime());
		cal.set(Calendar.MONTH, 1);
		cal.set(Calendar.DATE, 1);
		System.out.println(cal.getTime());
		//Actual 实际 Maximum最大
		//获取cal中当前月的最大日期值
		n = cal.getActualMaximum(
			Calendar.DAY_OF_MONTH);
		System.out.println(n); 

	}
}


