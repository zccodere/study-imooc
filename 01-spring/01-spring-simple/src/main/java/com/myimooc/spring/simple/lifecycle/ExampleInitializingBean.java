package com.myimooc.spring.simple.lifecycle;

import org.springframework.beans.factory.InitializingBean;

/**
 * <br>
 * 标题: Bean初始化时执行<br>
 * 描述: Bean初始化时执行<br>
 * 时间: 2017/01/18<br>
 *
 * @author zc
 */
public class ExampleInitializingBean implements InitializingBean {

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(this.getClass().getName() + "：initializing");
    }

}
