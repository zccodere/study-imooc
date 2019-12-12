package com.myimooc.spring.simple.beanannotation;

import com.myimooc.spring.simple.AbstractUnitTestSupport;
import com.myimooc.spring.simple.beanannotation.multibean.BeanInvoker;
import com.myimooc.spring.simple.ioc.injection.service.InjectionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;


/**
 * <br>
 * 标题: BeanInvoker测试<br>
 * 描述: BeanInvoker测试<br>
 * 时间: 2017/01/18<br>
 *
 * @author zc
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class InjectionTest extends AbstractUnitTestSupport {
	
	public InjectionTest() {
		super("classpath:spring-beanannotation.xml");
	}
	
	@Test
	public void testAutowired() {
		InjectionService service = super.getBean("injectionServiceImpl");
		service.save("This is autowired.");
	}
	
	@Test
	public void testMultiBean() {
		BeanInvoker invoker = super.getBean("beanInvoker");
		invoker.say();
	}
	
}
