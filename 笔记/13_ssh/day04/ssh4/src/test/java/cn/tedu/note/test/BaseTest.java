package cn.tedu.note.test;

import org.junit.After;
import org.junit.Before;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public abstract class BaseTest {

	protected ClassPathXmlApplicationContext ctx;

	@Before
	public void initCtx() {
		ctx = new ClassPathXmlApplicationContext(
				"conf/spring-hbm.xml",
				"conf/spring-service.xml");
	}

	@After
	public void close() {
		ctx.close();
	}

}