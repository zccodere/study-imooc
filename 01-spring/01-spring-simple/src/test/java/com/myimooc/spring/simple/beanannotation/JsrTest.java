package com.myimooc.spring.simple.beanannotation;


import com.myimooc.spring.simple.AbstractUnitTestSupport;
import com.myimooc.spring.simple.beanannotation.jsr.JsrService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;


/**
 * <br>
 * 标题: 基于JSR标准的注解使用测试<br>
 * 描述: 基于JSR标准的注解使用测试<br>
 * 时间: 2017/01/18<br>
 *
 * @author zc
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class JsrTest extends AbstractUnitTestSupport {
	
	public JsrTest() {
		super("classpath*:spring-beanannotation.xml");
	}
	
	@Test
	public void testSave() {
		JsrService service = getBean("jsrService");
		service.save();
	}
	
}
