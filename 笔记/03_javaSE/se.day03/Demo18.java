package day03;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
/**
 * 一个复杂的时间案例 
 */
public class Demo18 {
	public static void main(String[] args) 
		throws Exception{
		//逻辑分析：
		//输入： "2016-8-1"
		//date -> Calender
		//计算出到期时间  cal.add(YEAR,3)
		//计算提示时间 cal.add(MONTH, -2);
		//w = cal.get(DAY_OF_WEEK);
		//if(w 是星期六) cal.add(DATE,2)
		//if(w 是星期日) cal.add(DATE,1)
		//找到提醒时间
		
		//代码实现：
		Scanner in = new Scanner(System.in);
		System.out.print(
			"输入入职时间(yyyy-MM-dd)：");
		String str = in.nextLine();
		SimpleDateFormat fmt=
			new SimpleDateFormat("yyyy-MM-dd");
		Date date = fmt.parse(str);
		Calendar cal=Calendar.getInstance();
		//修改cal中的时间，为date的时间
		cal.setTime(date);
		Demo17.print(cal);//入职
		cal.add(Calendar.YEAR, 3);//3年后到期
		Demo17.print(cal);
		cal.add(Calendar.MONTH, -2);
		Demo17.print(cal);
		int w = cal.get(Calendar.DAY_OF_WEEK);
		if(w == Calendar.SATURDAY){
			cal.add(Calendar.DATE, 2);
		}else if(w == Calendar.SUNDAY){
			cal.add(Calendar.DATE, 1);
		}
		System.out.print("提醒时间：");
		Demo17.print(cal);
	}
}







