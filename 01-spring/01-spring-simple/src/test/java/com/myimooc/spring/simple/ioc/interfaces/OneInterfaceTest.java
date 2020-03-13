package com.myimooc.spring.simple.ioc.interfaces;

import com.myimooc.spring.simple.AbstractTestSupport;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

/**
 * 面向接口编程测试
 *
 * @author zc 2017-01-18
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class OneInterfaceTest extends AbstractTestSupport {

    public OneInterfaceTest() {
        super("spring-ioc.xml");
    }

    @Test
    public void testSay() {
        OneInterface oneInterface = super.getBean("oneInterface", OneInterface.class);
        oneInterface.say("This is a test.");
    }

}
