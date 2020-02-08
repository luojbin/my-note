package test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import dao.EmployeeDAO;
import entity.Employee;

public class TestCase {
	private SqlSession session;
	@Before
	public void init(){
		String config = "SqlMapConfig.xml";
		SqlSessionFactoryBuilder ssfb = 
			new SqlSessionFactoryBuilder();
		SqlSessionFactory ssf = 
			ssfb.build(
			TestCase.class.getClassLoader()
			.getResourceAsStream(config));
		session = ssf.openSession();
	}
	
	@Test
	public void test1(){
		//MyBatis会返回一个符合
		//Mapper映射器要求的对象。
		EmployeeDAO dao = 
			session.getMapper(
					EmployeeDAO.class);
		Employee e = new Employee();
		e.setName("Sally");
		e.setAge(22);
		dao.save(e);
		//仍然需要提交事务
		session.commit();
		session.close();
	}
	
	@Test
	public void test2(){
		EmployeeDAO dao = 
				session.getMapper(
						EmployeeDAO.class);
		List<Employee> employees =
			dao.findAll();
		System.out.println(employees);
		session.close();
	}
	
	@Test
	public void test3(){
		EmployeeDAO dao = 
			session.getMapper(EmployeeDAO.class);
		Employee e = 
				dao.findById(3);
		System.out.println(e);
		session.close();
	}
}




