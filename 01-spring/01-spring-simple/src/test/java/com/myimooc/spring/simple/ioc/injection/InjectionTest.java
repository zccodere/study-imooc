package com.myimooc.spring.simple.ioc.injection;

import com.myimooc.spring.simple.AbstractTestSupport;
import com.myimooc.spring.simple.ioc.injection.service.InjectionService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

/**
 * Bean注入测试类
 *
 * @author zc 2017-01-18
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class InjectionTest extends AbstractTestSupport {

    public InjectionTest() {
        super("spring-injection.xml");
    }

    @Test
    public void testSetter() {
        InjectionService service = super.getBean("injectionService", InjectionService.class);
        service.save("这是要保存的数据");
    }

    @Test
    public void testCons() {
        InjectionService service = super.getBean("injectionService", InjectionService.class);
        service.save("这是要保存的数据");
    }

}
