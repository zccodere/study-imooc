package com.myimooc.spring.simple.aware;

import com.myimooc.spring.simple.AbstractTestSupport;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

/**
 * Aware接口测试
 *
 * @author zc 2017-01-18
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class AwareTest extends AbstractTestSupport {

    public AwareTest() {
        super("spring-aware.xml");
    }

    @Test
    public void testMockApplicationContext() {
        System.out.println("testMockApplicationContext : " + super.getBean("mockApplicationContext", MockApplicationContext.class).hashCode());
    }

    @Test
    public void textMockBeanName() {
        System.out.println("textMockBeanName : " + super.getBean("mockBeanName", MockBeanName.class).hashCode());
    }

}
