package com.myimooc.spring.simple.lifecycle;


import com.myimooc.spring.simple.AbstractTestSupport;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

/**
 * Bean生命周期测试
 *
 * @author zc 2017-01-18
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class BeanLifecycleTest extends AbstractTestSupport {

    public BeanLifecycleTest() {
        super("spring-lifecycle.xml");
    }

    @Test
    public void test1() {
        super.getBean("beanLifeCycle", BeanLifeCycle.class);
        super.getBean(ExampleInitializingBean.class);
        super.getBean(ExampleDisposableBean.class);
    }

}
