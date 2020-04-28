package com.myimooc.java.design.pattern.template;

/**
 * 模版模式；具体子类，提供了咖啡之中的具体实现
 *
 * @author zc 2017-09-02
 */
public class Coffee extends AbstractRefreshBeverage {

    @Override
    protected void addCondiments() {
        System.out.println("用沸水冲泡咖啡");
    }

    @Override
    protected void brew() {
        System.out.println("加入糖和牛奶");
    }
}
