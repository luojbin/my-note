package test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.EmployeeDAO;
import entity.Employee;

public class TestCase {
	@Test
	public void test1(){
		String config = "mybatis-spring.xml";
		ApplicationContext ac = 
			new ClassPathXmlApplicationContext(
					config);
		EmployeeDAO dao = 
				ac.getBean("empDAO",
						EmployeeDAO.class);
		List<Employee> employees = 
			dao.findAll();
		System.out.println(employees);
	}
	
	
	
}
