package day03;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 将字符串解析为 系统时间（毫秒数） 
 */
public class Demo11 {
	public static void main(String[] args)
		throws Exception{
		String str = "1980-5-6";
		String pattern = "yyyy-M-d";
		SimpleDateFormat fmt=
			new SimpleDateFormat(pattern);
		//将字符串时间解析为计算机时间
		Date date=fmt.parse(str);
		System.out.println(date);
		System.out.println(date.getTime());
		
		String id="12345619891405123122x";
		//         012345678901234
		String s = id.substring(6,6+8);
		System.out.println(s); 
		pattern = "yyyyMMdd";
		fmt=new SimpleDateFormat(pattern);
		date = fmt.parse(s);
		System.out.println(date); 
		
	}

}



