package day03;

import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * SimpleDateFormat 用于将Java系统时候
 * 换算为人类习惯的 年月日 时分秒。
 */
public class Demo09 {
	public static void main(String[] args) {
		SimpleDateFormat fmt=
			new SimpleDateFormat();
		Date date = new Date();
		//将系统时间换算为人类习惯的时间
		String str = fmt.format(date);
		System.out.println(str); 
	}
}
