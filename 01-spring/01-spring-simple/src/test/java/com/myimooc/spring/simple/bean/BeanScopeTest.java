package com.myimooc.spring.simple.bean;

import com.myimooc.spring.simple.AbstractUnitTestSupport;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

/**
 * <br>
 * 标题: Bean作用域测试<br>
 * 描述: Bean作用域测试<br>
 * 时间: 2017/01/18<br>
 *
 * @author zc
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class BeanScopeTest extends AbstractUnitTestSupport {

    public BeanScopeTest() {
        super("classpath*:spring-beanscope.xml");
    }

    @Test
    public void testSay() {
        BeanScope beanScope = super.getBean("beanScope");
        beanScope.say();

        BeanScope beanScope2 = super.getBean("beanScope");
        beanScope2.say();
    }

    @Test
    public void testSay2() {
        BeanScope beanScope = super.getBean("beanScopeSingleton");
        beanScope.say();

        BeanScope beanScope2 = super.getBean("beanScopeSingleton");
        beanScope2.say();
    }

}
