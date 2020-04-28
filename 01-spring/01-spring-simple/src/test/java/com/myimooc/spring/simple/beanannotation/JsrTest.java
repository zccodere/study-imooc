package com.myimooc.spring.simple.beanannotation;

import com.myimooc.spring.simple.AbstractTestSupport;
import com.myimooc.spring.simple.beanannotation.jsr.JsrService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

/**
 * 基于JSR标准的注解使用测试
 *
 * @author zc 2017-01-18
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class JsrTest extends AbstractTestSupport {

    public JsrTest() {
        super("spring-beanannotation.xml");
    }

    @Test
    public void testSave() {
        JsrService service = getBean(JsrService.class);
        service.save();
    }

}
