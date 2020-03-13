package com.myimooc.spring.simple.aware;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * ApplicationContextAware扩展接口；获取ApplicationContext
 *
 * @author zc 2017-01-18
 */
public class MockApplicationContext implements ApplicationContextAware {

    @Override
    public void setApplicationContext(ApplicationContext applicationContext)
            throws BeansException {
        System.out.println("MockApplicationContext : " + applicationContext.getBean("mockApplicationContext").hashCode());
    }

}
