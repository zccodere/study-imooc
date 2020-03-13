package com.myimooc.spring.simple.beanannotation;

import com.myimooc.spring.simple.AbstractTestSupport;
import com.myimooc.spring.simple.beanannotation.multiple.BeanInvoker;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

/**
 * BeanInvoker测试
 *
 * @author zc 2017-01-18
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class MultipleTest extends AbstractTestSupport {

    public MultipleTest() {
        super("spring-beanannotation.xml");
    }

    @Test
    public void testMultiBean() {
        BeanInvoker invoker = super.getBean(BeanInvoker.class);
        invoker.say();
    }

}
