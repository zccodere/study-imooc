package com.myimooc.spring.simple.lifecycle;

import org.springframework.beans.factory.DisposableBean;

/**
 * <br>
 * 标题: Bean销毁时执行<br>
 * 描述: Bean销毁时执行<br>
 * 时间: 2017/01/18<br>
 *
 * @author zc
 */
public class ExampleDisposableBean implements DisposableBean {

    @Override
    public void destroy() throws Exception {
        System.out.println(this.getClass().getName() + "：destroy");
    }

}
