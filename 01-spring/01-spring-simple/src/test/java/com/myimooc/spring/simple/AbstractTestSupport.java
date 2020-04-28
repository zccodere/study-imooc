package com.myimooc.spring.simple;

import org.junit.After;
import org.junit.Before;
import org.springframework.beans.BeansException;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.StringUtils;

/**
 * 支持单元测试抽象基类
 *
 * @author zc 2017-01-18
 */
public abstract class AbstractTestSupport {

    private ClassPathXmlApplicationContext context;

    private String springXmlPath;

    public AbstractTestSupport() {
    }

    public AbstractTestSupport(String springXmlPath) {
        this.springXmlPath = springXmlPath;
    }

    @Before
    public void before() {
        if (StringUtils.isEmpty(springXmlPath)) {
            springXmlPath = "classpath*:spring-*.xml";
        }
        try {
            context = new ClassPathXmlApplicationContext(springXmlPath.split("[,\\s]+"));
            context.start();
        } catch (BeansException e) {
            e.printStackTrace();
        }
    }

    @After
    public void after() {
        context.close();
    }

    protected <T> T getBean(String beanId, Class<T> typeClass) {
        try {
            return context.getBean(beanId, typeClass);
        } catch (BeansException e) {
            throw new RuntimeException("获取Bean异常：", e);
        }
    }

    protected <T> T getBean(Class<T> clazz) {
        try {
            return context.getBean(clazz);
        } catch (BeansException e) {
            throw new RuntimeException("获取Bean异常：", e);
        }
    }
}
