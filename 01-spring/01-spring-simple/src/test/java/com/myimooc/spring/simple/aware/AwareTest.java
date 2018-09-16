package com.myimooc.spring.simple.aware;

import com.myimooc.spring.simple.AbstractUnitTestSupport;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

/**
 * <br>
 * 标题: Aware接口测试<br>
 * 描述: Aware接口测试<br>
 * 时间: 2017/01/18<br>
 *
 * @author zc
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class AwareTest extends AbstractUnitTestSupport {

    public AwareTest() {
        super("classpath:spring-aware.xml");
    }

	@Test
	public void testMoocApplicationContext() {
		System.out.println("testMoocApplicationContext : " + super.getBean("moocApplicationContext").hashCode());
	}

    @Test
    public void textMoocBeanName() {
        System.out.println("textMoocBeanName : " + super.getBean("moocBeanName").hashCode());
    }

}
