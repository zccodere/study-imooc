package com.myimooc.spring.simple.aop.schema.advice.biz;

/**
 * <br>
 * 标题: 业务方法<br>
 * 描述: 业务方法<br>
 * 时间: 2017/01/18<br>
 *
 * @author zc
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
