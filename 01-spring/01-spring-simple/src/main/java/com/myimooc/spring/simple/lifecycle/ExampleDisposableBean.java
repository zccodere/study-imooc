package com.myimooc.spring.simple.lifecycle;

import org.springframework.beans.factory.DisposableBean;

/**
 * Bean销毁时执行
 *
 * @author zc 2017-01-18
 */
public class ExampleDisposableBean implements DisposableBean {

    @Override
    public void destroy() {
        System.out.println(this.getClass().getName() + "：destroy");
    }

}
