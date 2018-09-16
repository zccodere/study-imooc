package com.myimooc.spring.simple.aop.schema.advice;

/**
 * <br>
 * 标题: 接口实现<br>
 * 描述: 接口实现<br>
 * 时间: 2017/01/18<br>
 *
 * @author zc
 */
public class FitImpl implements Fit {

    @Override
    public void filter() {
        System.out.println("FitImpl filter.");
    }

}
