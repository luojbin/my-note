package cn.tedu.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.HibernateTemplate;

import cn.tedu.entity.Person;

public class SpringHibernateTest {
	
	ClassPathXmlApplicationContext ctx;
	HibernateTemplate temp;
	@Before
	public void init(){
		ctx = new ClassPathXmlApplicationContext(
			"spring-orm.xml");
		temp = ctx.getBean(
				"hibernateTemplate",
				HibernateTemplate.class);
	}
	@After
	public void destroy(){
		ctx.close();
	}
	
	@Test
	public void testGet(){
		//HibernateTemplate 可以替代 session
		//并且使用更加简便(可以不用管理事务,等)
		Person p = temp.get(Person.class, 1);
		System.out.println(p); 
	}
}







