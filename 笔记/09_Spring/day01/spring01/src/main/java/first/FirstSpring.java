package first;

import java.util.Calendar;
import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FirstSpring {

	public static void main(String[] args) {
		String config = 
				"applicationcontext.xml";
		/*
		 * ApplicationContext是接口
		 * ClassPathXmlApplicationContext是
		 * 一个实现类，该类会依据类路径去
		 * 查找spring配置文件，然后启动容器。
		 */
		ApplicationContext ac = 
		new ClassPathXmlApplicationContext(
				config);
//		System.out.println(ac);
		
		//Student.class 方法区中的class对象。
		Student stu = 
				ac.getBean("stu1",
						Student.class);
		System.out.println(stu);
		
		Date date1 =
				ac.getBean("date1",Date.class);
		System.out.println(date1);
		
		Calendar cal1 = 
				ac.getBean("cal1",
						Calendar.class);
		System.out.println(cal1);
		
		Date time1 = 
				ac.getBean("time1",Date.class);
		System.out.println(time1);
		
	}

}
