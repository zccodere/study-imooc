package com.myimooc.spring.simple.lifecycle;

import org.springframework.beans.factory.InitializingBean;

/**
 * Bean初始化时执行
 *
 * @author zc 2017-01-18
 */
public class ExampleInitializingBean implements InitializingBean {

    @Override
    public void afterPropertiesSet() {
        System.out.println(this.getClass().getName() + "：initializing");
    }

}
