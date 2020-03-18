package com.myimooc.java.design.pattern.template;

/**
 * 模版模式；抽象基类，为所有子类提供一个算法框架。提神饮料
 *
 * @author zc 2017-09-02
 */
public abstract class AbstractRefreshBeverage {

    /**
     * 制备饮料的模版方法 封装了所有子类共同遵循的算法框架
     */
    public final void prepareBeverageTemplate() {
        // 步骤1 将水煮沸
        boilWater();

        // 步骤2 泡制饮料
        brew();

        // 步骤3 将饮料倒入杯中
        pourInCup();

        if (isCustomerWantsCondiments()) {
            // 步骤4 加入调味料
            addCondiments();
        }
    }

    /**
     * Hook 方法（钩子函数），提供一个默认或空的实现 具体的子类可以自行决定是否挂钩以及如何挂钩 询问用户是否加入调料
     */
    protected boolean isCustomerWantsCondiments() {
        // 默认需要加入调味料
        return true;
    }

    /**
     * 基本方法，将水煮沸
     */
    private void boilWater() {
        System.out.println("将水煮沸");
    }

    /**
     * 基本方法，将饮料倒入杯中
     */
    private void pourInCup() {
        System.out.println("将饮料倒入杯中");

    }

    /**
     * 抽象的基本方法，泡制饮料
     */
    protected abstract void addCondiments();

    /**
     * 抽象的基本方法，加入调味料
     */
    protected abstract void brew();

}
