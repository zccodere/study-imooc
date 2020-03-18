package com.myimooc.java.design.pattern.template;

/**
 * 模版模式；测试类
 *
 * @author zc 2017-09-02
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("制备咖啡...");
        AbstractRefreshBeverage b1 = new Coffee();
        b1.prepareBeverageTemplate();
        System.out.println("咖啡好了！");

        System.out.println("\n****************************************");

        System.out.println("制备茶...");
        AbstractRefreshBeverage b2 = new Tea();
        b2.prepareBeverageTemplate();
        System.out.println("茶好了！");
    }
}
