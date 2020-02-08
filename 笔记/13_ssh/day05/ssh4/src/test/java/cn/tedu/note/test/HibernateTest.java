package cn.tedu.note.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cn.tedu.note.entity.Comment;
import cn.tedu.note.entity.Person;
import cn.tedu.note.entity.Post;
import cn.tedu.note.entity.User;

public class HibernateTest extends BaseTest {
	SessionFactory factory;
	Session session;
	@Before 
	public void initSession(){
		factory = ctx.getBean("sessionFactory",
				SessionFactory.class);
		session = factory.openSession();
	}
	@After
	public void destory(){
		session.close();
		factory.close();
	}
	@Test
	public void testSessionFactory(){
		//Spring 简化了 Session Factory 的关联
		SessionFactory factory =
				ctx.getBean("sessionFactory",
				SessionFactory.class);
		//利用SessionFactory创建Session
		Session session = factory.openSession();
		System.out.println(session);
		
		session.close();
		System.out.println(factory);
	}
	
	@Test
	public void testSave(){
		Transaction tx=session.beginTransaction();
		//持久状态下,更改属性影响到数据库
		//user 对象 是临时状态的
		User user = new User(
			"1234567", "熊大", "1234", "", "");
		//user成为持久状态
		session.save(user);
		user.setName("范传奇");
		user.setPassword("abcde");
		tx.commit();
	}
	
	
	@Test
	public void testGet(){
		Transaction tx=session.beginTransaction();
		//get返回对象是持久状态的
		User user = (User)session.get(
			User.class, "1234567");
		System.out.println(user);
		//更改持久创建对象的属性影响数据库
		user.setName("李洪鹤"); 
		tx.commit();
	}
	
	@Test
	public void testEvict(){
		Transaction tx = session.beginTransaction();
		//get返回的对象是持久状态
		User user = (User)session.get(
				User.class, "1234567");
		System.out.println(user);
		//evict将对象清除 sessin缓存, 变成游离状态
		session.evict(user);
		//session.clear();
		user.setName("光头强");
		tx.commit();
	}
	
	@Test
	public void testUpdate(){
		Transaction tx = session.beginTransaction();
		//get返回的对象是持久状态
		User user = (User)session.get(
				User.class, "1234567");
		System.out.println(user);
		//evict将对象清除 sessin缓存, 变成游离状态
		session.evict(user);
		//session.clear();
		user.setName("光头强");
		//update 方法 将对象从游离状态改为持久状态
		session.update(user); 
		
		tx.commit();
	}

	@Test
	public void testDelete(){
		Transaction tx = session.beginTransaction();
		//get返回的对象是持久状态
		User user = (User)session.get(
				User.class, "1234567");
		System.out.println(user);
		//delete方法将数据从数据库删除, 
		// 对象user在内存中还有数据
		// 此时对象是临时状态的!
		session.delete(user); 
		System.out.println(user);
		
		tx.commit();
	}

	@Test 
	public void testLoad(){
		//get方法在没有数据时候, 返回null
		User user = (User)session.get(
			User.class, "1234567");
		System.out.println(user); //null
		//load方法在没有数据时候, 抛出异常
		User u = (User) session.load(
			User.class, "1234567");
		System.out.println(u); 
	}
	
	@Test
	public void testQuery(){
		//执行HQL查询
		Transaction tx=session.beginTransaction();
		//sql: select * from cn_user
		String hql = "from User"; 
		Query query=session.createQuery(hql);
		//list 执行返回一组数据的查询
		List<User> list = query.list();
		for (User user : list) {
			System.out.println(user);
		}
		tx.commit();
	}
	
	@Test
	public void testQuery2(){
		//执行带参数的SQL
		//sql: select * from cn_user 
		//     where cn_user_name like ? 
		String hql = "from User "
				+ "where name like ?"; 
		Transaction tx = session.beginTransaction();
		Query query=session.createQuery(hql);
		//绑定查询参数
		query.setString(0, "%o%");
		//执行查询
		List<User> list=query.list();
		for (User user : list) {
			System.out.println(user);
		}
		tx.commit();
	}
	
	@Test
	public void testQuery3(){
		//按照名字绑定参数
		String hql = "from User "
				+ "where name like :name"; 
		Transaction tx = session.beginTransaction();
		Query query=session.createQuery(hql);
		//绑定查询参数
		query.setString("name", "%o%");
		//执行查询
		List<User> list=query.list();
		for (User user : list) {
			System.out.println(user);
		}
		tx.commit();
	}
	
	@Test
	public void testQuery4(){
		//query 支持唯一结果查询
		Transaction tx = session.beginTransaction();
		String hql = "from User where name=?";
		Query query = session.createQuery(hql);
		query.setString(0, "demo");
		//uniqueResult 用于查找返回唯一的结果
		User user = (User)query.uniqueResult();
		System.out.println(user);
		user.setToken("123456"); 
		tx.commit();
	}
	
	@Test
	public void testFindPerson(){
		String hql = "from Person";
		Query query = session.createQuery(hql);
		List<Person> list = query.list();
		for (Person person : list) {
			System.out.println(person); 
		}
	}
	@Test
	public void testAddPerson(){
		Person person = new Person(null, "Wang");
		System.out.println(person);
		Transaction tx = session.beginTransaction();
		session.save(person);
		System.out.println(person);
		tx.commit();
	}
	
	@Test
	public void testFindComment(){
		String hql = "from Comment";
		Query query = session.createQuery(hql);
		List<Comment> list = query.list();
		for (Comment comment : list) {
			System.out.println(comment); 
		}
	}
	
	@Test
	public void testFindPost(){
		String hql = "from Post";
		Query query = session.createQuery(hql);
		List<Post> list = query.list();
		for (Post p : list) {
			System.out.println(p); 
		}
	}
	
}











