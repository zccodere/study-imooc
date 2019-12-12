package com.myimooc.spring.simple.ioc.interfaces;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import com.myimooc.spring.simple.AbstractUnitTestSupport;

/**
 * <br>
 * 标题: 面向接口编程测试<br>
 * 描述: 一个接口<br>
 * 时间: 2017/01/18<br>
 *
 * @author zc
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class OneInterfaceTest extends AbstractUnitTestSupport {

    public OneInterfaceTest() {
        super("classpath*:spring-ioc.xml");
    }

    @Test
    public void testSay() {
        OneInterface oneInterface = super.getBean("oneInterface");
        oneInterface.say("This is a test.");
    }

}
