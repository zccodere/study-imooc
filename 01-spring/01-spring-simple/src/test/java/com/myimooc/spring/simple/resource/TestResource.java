package com.myimooc.spring.simple.resource;

import java.io.IOException;

import com.myimooc.spring.simple.AbstractUnitTestSupport;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

/**
 * <br>
 * 标题: 模拟加载资源测试<br>
 * 描述: 模拟加载资源测试<br>
 * 时间: 2017/01/18<br>
 *
 * @author zc
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class TestResource extends AbstractUnitTestSupport {

    public TestResource() {
        super("classpath:spring-resource.xml");
    }

    @Test
    public void testResource() {
        MoocResource resource = super.getBean("moocResource");
        try {
            resource.resource();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
