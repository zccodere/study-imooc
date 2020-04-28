package com.myimooc.spring.simple.autowiring;

import com.myimooc.spring.simple.AbstractTestSupport;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

/**
 * 自动注入测试
 *
 * @author zc 2017-01-18
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class AutoWiringTest extends AbstractTestSupport {

    public AutoWiringTest() {
        super("spring-autowiring.xml");
    }

    @Test
    public void testSay() {
        AutoWiringService service = super.getBean("autoWiringService", AutoWiringService.class);
        service.say(" this is a test");
    }

}
