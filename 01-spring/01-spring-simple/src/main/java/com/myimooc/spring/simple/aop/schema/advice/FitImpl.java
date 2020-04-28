package com.myimooc.spring.simple.aop.schema.advice;

/**
 * 接口实现
 *
 * @author zc 2017-01-18
 */
public class FitImpl implements Fit {

    @Override
    public void filter() {
        System.out.println("FitImpl filter.");
    }

}
