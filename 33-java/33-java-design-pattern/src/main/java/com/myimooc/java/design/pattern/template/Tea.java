package com.myimooc.java.design.pattern.template;

/**
 * 模版模式；具体子类，提供了制备茶的具体实现
 *
 * @author zc 2017-09-02
 */
public class Tea extends AbstractRefreshBeverage {

    @Override
    protected void addCondiments() {
        System.out.println("用80度的热水浸泡茶叶5分钟");
    }

    @Override
    protected void brew() {
        System.out.println("加入柠檬");
    }

    /**
     * 子类通过覆盖的形式选择挂载钩子函数
     */
    @Override
    protected boolean isCustomerWantsCondiments() {
        return false;
    }
}
