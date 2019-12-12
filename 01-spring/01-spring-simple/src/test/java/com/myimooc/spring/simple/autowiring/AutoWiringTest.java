package com.myimooc.spring.simple.autowiring;

import com.myimooc.spring.simple.AbstractUnitTestSupport;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

/**
 * <br>
 * 标题: 自动注入测试<br>
 * 描述: 自动注入测试<br>
 * 时间: 2017/01/18<br>
 *
 * @author zc
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class AutoWiringTest extends AbstractUnitTestSupport {

    public AutoWiringTest() {
        super("classpath:spring-autowiring.xml");
    }

    @Test
    public void testSay() {
        AutoWiringService service = super.getBean("autoWiringService");
        service.say(" this is a test");
    }

}
