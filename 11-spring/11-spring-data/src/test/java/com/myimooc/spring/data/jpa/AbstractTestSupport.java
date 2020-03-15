package com.myimooc.spring.data.jpa;

import com.myimooc.spring.data.jpa.config.SpringConfig;

import org.junit.After;
import org.junit.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 测试基类
 *
 * @author zc 2017-04-24
 */
public abstract class AbstractTestSupport {

    protected ApplicationContext ctx = null;

    @Before
    public void init() {
        ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        initSub();
        System.out.println("init");
    }

    @After
    public void destroy() {
        ctx = null;
        System.out.println("destroy");
    }

    protected void initSub() {
    }
}
