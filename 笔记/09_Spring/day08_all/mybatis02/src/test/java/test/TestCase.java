package test;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import entity.Emp;
import entity.Employee;

public class TestCase {
	private SqlSession session;
	@Before
	public void init(){
		String config = "SqlMapConfig.xml";
		//创建SqlSessionFactoryBuidler对象
		SqlSessionFactoryBuilder ssfb = 
			new SqlSessionFactoryBuilder();
		//创建SqlSessionFactory对象
		SqlSessionFactory ssf = 
			ssfb.build(
			TestCase.class.getClassLoader()
			.getResourceAsStream(config));
		//获得SqlSession对象
		session = ssf.openSession();
	}
	
	@Test
	public void test1(){
		//调用SqlSession对象提供的方法访问数据库
		Employee e = new Employee();
		e.setName("Eric");
		e.setAge(33);
		session.insert("test.save", e);
		//添加，修改，删除都需要提交事务
		session.commit();
		//关闭SqlSession
		session.close();
	}
	
	@Test
	public void test2(){
		List<Employee> employees = 
				session.selectList(
						"test.findAll");
		System.out.println(employees);
		//session.close方法底层会归还
		//connection到连接池。
		session.close();
	}
	
	@Test
	public void test3(){
		Employee e = 
				session.selectOne(
				"test.findById", 2);
		System.out.println(e);
		session.close();
	}
	
	@Test
	public void test4(){
		Employee e = 
				session.selectOne(
				"test.findById", 2);
		e.setAge(e.getAge() * 2);
		session.update("test.modify", e);
		session.commit();
		session.close();
	}
	
	@Test
	public void test5(){
		session.delete("test.delete", 2);
		session.commit();
		session.close();
	}
	
	@Test
	//测试 返回Map类型的结果
	public void test6(){
		Map data = 
				session.selectOne(
				"test.findById2", 3);
		//注意：oracle数据库会将字段名
		//统一变成大写形式。
		System.out.println(
				data.get("NAME"));
		session.close();
	}
	
	@Test
	//测试  使用resultMap
	public void test7(){
		Emp emp = 
				session.selectOne(
			"test.findById3", 3);
		System.out.println(emp);
		session.close();
	}
	
	
	
	
	
	
}



