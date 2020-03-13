package com.myimooc.spring.simple.aop.schema.advice.biz;

/**
 * 务方法
 *
 * @author zc 2017-01-18
 */
public class AspectBiz {

    public void biz() {
        System.out.println("AspectBiz biz.");
//		throw new RuntimeException();
    }

    public void init(String bizName, int times) {
        System.out.println("AspectBiz init : " + bizName + "   " + times);
    }

}
