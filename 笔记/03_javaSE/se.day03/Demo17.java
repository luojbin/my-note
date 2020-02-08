package day03;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期相对增加方法 add 
 */
public class Demo17 {
	public static void print(Calendar cal){ 
		SimpleDateFormat fmt = 
				new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		Date date = cal.getTime();
		System.out.println(fmt.format(date)); 
	}
	public static void main(String[] args) {
		Calendar cal=Calendar.getInstance();
		print(cal); 
		
		//将cal中的当前时间的月份分量上
		//增加5个月的时间。
		cal.add(Calendar.MONTH, -5);
		print(cal); 
		
		cal.add(Calendar.DATE, 5);
		print(cal); 
	}
}






