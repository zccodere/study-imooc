package com.myimooc.spring.simple.resource;

import com.myimooc.spring.simple.AbstractTestSupport;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import java.io.IOException;

/**
 * 模拟加载资源测试
 *
 * @author zc 2017-01-18
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class ResourceTest extends AbstractTestSupport {

    public ResourceTest() {
        super("spring-resource.xml");
    }

    @Test
    public void testResource() {
        MockResource resource = super.getBean("mockResource", MockResource.class);
        try {
            resource.resource();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
