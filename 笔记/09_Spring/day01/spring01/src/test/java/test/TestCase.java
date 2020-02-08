package test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import basic.MessageService;

public class TestCase {
	@Test
	//测试 作用域 和 延迟加载
	public void test1(){
		String config = "basic.xml";
		//启动spring容器
		ApplicationContext ac = 
		new ClassPathXmlApplicationContext(
				config);
		//通过容器获得bean
		//Teacher t1 = 
			//	ac.getBean("t1",Teacher.class);
		//Teacher t2 =
				//ac.getBean("t1",Teacher.class);
		//System.out.println(t1 == t2);
	}
	
	@Test
	//测试 生命周期相关的两个方法
	public void test2(){
		String config = "basic.xml";
		//启动spring容器
		/*
		 * ApplicationContext接口当中并没有
		 * 提供关闭容器的方法(close方法),
		 * 需要用其子接口
		 * AbstractApplicationContext
		 */
		AbstractApplicationContext ac = 
		new ClassPathXmlApplicationContext(
				config);
		MessageService ms1 = 
				ac.getBean("ms1",
						MessageService.class);
		//关闭容器
		ac.close();
	}
}





