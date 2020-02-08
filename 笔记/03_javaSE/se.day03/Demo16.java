package day03;

import java.util.Calendar;

/**
 * 输出每个月的最大日期 
 */
public class Demo16 {
	public static void main(String[] args) {
		Calendar cal=Calendar.getInstance();
		
		for(int i=Calendar.JANUARY; 
				i<=Calendar.DECEMBER; i++){
			cal.set(Calendar.MONTH, i);
			cal.set(Calendar.DATE,1);
			int max=cal.getActualMaximum(
				Calendar.DAY_OF_MONTH);
			System.out.println(max); 
		}
	}
}








