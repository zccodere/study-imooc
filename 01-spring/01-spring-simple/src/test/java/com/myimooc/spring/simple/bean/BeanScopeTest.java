package com.myimooc.spring.simple.bean;

import com.myimooc.spring.simple.AbstractTestSupport;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

/**
 * Bean作用域测试
 *
 * @author zc 2017-01-18
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class BeanScopeTest extends AbstractTestSupport {

    public BeanScopeTest() {
        super("spring-beanscope.xml");
    }

    @Test
    public void testSay() {
        BeanScope beanScope = super.getBean("beanScope", BeanScope.class);
        beanScope.say();

        BeanScope beanScope2 = super.getBean("beanScope", BeanScope.class);
        beanScope2.say();
    }

    @Test
    public void testSay2() {
        BeanScope beanScope = super.getBean("beanScopeSingleton", BeanScope.class);
        beanScope.say();

        BeanScope beanScope2 = super.getBean("beanScopeSingleton", BeanScope.class);
        beanScope2.say();
    }

}
