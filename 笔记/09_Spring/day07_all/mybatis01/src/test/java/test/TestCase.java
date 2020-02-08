package test;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import entity.Employee;

public class TestCase {
	@Test
	public void test1(){
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
		SqlSession session = 
				ssf.openSession();
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
}



