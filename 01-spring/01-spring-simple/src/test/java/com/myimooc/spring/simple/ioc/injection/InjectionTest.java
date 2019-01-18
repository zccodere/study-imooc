package com.myimooc.spring.simple.ioc.injection;

import com.myimooc.spring.simple.AbstractUnitTestSupport;
import com.myimooc.spring.simple.ioc.injection.service.InjectionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

@RunWith(BlockJUnit4ClassRunner.class)
public class InjectionTest extends AbstractUnitTestSupport {
	
	public InjectionTest() {
		super("classpath:spring-injection.xml");
	}
	
	@Test
	public void testSetter() {
		InjectionService service = super.getBean("injectionService");
		service.save("这是要保存的数据");
	}
	
	@Test
	public void testCons() {
		InjectionService service = super.getBean("injectionService");
		service.save("这是要保存的数据");
	}
	
}
