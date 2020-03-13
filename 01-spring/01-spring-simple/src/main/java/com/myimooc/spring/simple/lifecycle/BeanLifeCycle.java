package com.myimooc.spring.simple.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * Bean生命周期
 *
 * @author zc 2017-01-18
 */
public class BeanLifeCycle implements InitializingBean, DisposableBean {

    public void defaultInit() {
        System.out.println("Bean defaultInit.");
    }

    public void defaultDestroy() {
        System.out.println("Bean defaultDestroy.");
    }

    @Override
    public void destroy() {
        System.out.println("Bean destroy.");
    }

    @Override
    public void afterPropertiesSet() {
        System.out.println("Bean afterPropertiesSet.");
    }

    public void start() {
        System.out.println("Bean start .");
    }

    public void stop() {
        System.out.println("Bean stop.");
    }

}
