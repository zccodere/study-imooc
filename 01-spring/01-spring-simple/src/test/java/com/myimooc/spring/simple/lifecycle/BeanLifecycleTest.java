package com.myimooc.spring.simple.lifecycle;


import com.myimooc.spring.simple.AbstractUnitTestSupport;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

/**
 * <br>
 * 标题: Bean生命周期测试<br>
 * 描述: Bean生命周期测试<br>
 * 时间: 2017/01/18<br>
 *
 * @author zc
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class BeanLifecycleTest extends AbstractUnitTestSupport {

    public BeanLifecycleTest() {
        super("classpath:spring-lifecycle.xml");
    }

    @Test
    public void test1() {
        super.getBean("beanLifeCycle");
    }

}
