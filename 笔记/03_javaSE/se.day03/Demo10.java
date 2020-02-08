package day03;

import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * 自定义时间格式化显示 
 */
public class Demo10 {
	public static void main(String[] args) {
		SimpleDateFormat fmt = 
			new SimpleDateFormat(
				"yyyy年M月d日 HH:mm:ss");
		Date date = new Date();
		System.out.println(date);
		System.out.println(fmt.format(date));  
	}
}






