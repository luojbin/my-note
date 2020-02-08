package day03;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
/**
 * 历法类的使用
 * 历法是替代 Date 类型的API，用于替换
 * Date类型的那些过时的API方法 
 */
public class Demo12 {
	public static void main(String[] args) {
		Calendar c1 = 
			new GregorianCalendar();
		Calendar c2 = Calendar.getInstance();
		//默认的Calendar里面封装是当前系统时间
		System.out.println(c1);
		System.out.println(c2);
		//将Calender转换为Date类型
		Date date = c1.getTime();
		SimpleDateFormat fmt =
			new SimpleDateFormat();
		System.out.println(fmt.format(date));
		
		//创建指定年月日的Calender
		Calendar cal = 
			new GregorianCalendar(
				2017, Calendar.MARCH, 6);
		//输出结果：
		date = cal.getTime();
		System.out.println(fmt.format(date)); 
	}
}











