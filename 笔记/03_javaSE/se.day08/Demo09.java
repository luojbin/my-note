package day08;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 异常处理 
 */
public class Demo09 {
	public static void main(String[] args) 
		throws Exception {
		SimpleDateFormat fmt =
			new SimpleDateFormat("yyyy-MM-dd");
		String str = "A2017-03-01";//"一九九七年";
		String s = "a55";
		Date d=null;
		int age=0;
		try{
			d = fmt.parse(str);
			age = Integer.parseInt(s);
		}catch(ParseException e){
			System.out.println("替换系统时间");
			d = new Date();
		}catch(NumberFormatException e){
			System.out.println("处理数字解析异常");
			age = 18;
		}
		System.out.println(d);
		System.out.println(age); 
		//...
	}
}




