package cn.tedu.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cn.tedu.entity.Person;

public class HibernateTest {
	
	SessionFactory factory;
	Session session;
	@Before
	public void init(){
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		factory = cfg.buildSessionFactory();
		session = factory.openSession();
	}
	
	@After
	public void destory(){
		session.close();
		factory.close();
	}
	
	@Test
	public void testGet(){
		Person p = (Person)session.get(
				Person.class, 7);
		System.out.println(p);
	}
	@Test
	public void testAdd(){
		//将新对象保存到数据库中, 需要开启事务
		Transaction tx=session.beginTransaction();
		Person one = new Person(null, "熊大");
		session.save(one);
		tx.commit();//提交事务
		System.out.println(one);
	}
	
	@Test
	public void testUpdate(){
		//更新数据 
		Transaction tx = session.beginTransaction();
		Person p = (Person)session.get(
				Person.class, 7);
		p.setName("范传奇"); 
		session.update(p);
		tx.commit();
	}
	
	@Test
	public void testDelete(){
		//更新数据 
		Transaction tx = session.beginTransaction();
		Person p = (Person)session.get(
				Person.class, 7);
		session.delete(p);
		tx.commit();
	}
	
	
	@Test
	public void testSavePerson(){
		//参考: Hibernate 官方手册!
		
		//读取配置文件
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		//创建Session工厂
		SessionFactory factory = 
				cfg.buildSessionFactory();
		//利用Session工厂创建Session 
		Session session=factory.openSession();
		//session 自动提供了对象的 CRUD 操作方法
		
		//从数据库中查询id为1的person对象
		Person p = 
			(Person)session.get(Person.class,1);
		System.out.println(p);
		
		//最后务必关闭 session
		session.close();
	}
}








