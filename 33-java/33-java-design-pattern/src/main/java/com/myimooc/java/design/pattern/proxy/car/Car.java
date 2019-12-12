package com.myimooc.java.design.pattern.proxy.car;

import java.util.Random;

/**
 * @author zc
 * @version 1.0 2017-08-28
 * @describe 一辆车实现可行驶的接口
 */
public class Car implements MoveAble {

    @Override
    public void move() {
        // 记录汽车行驶的时间
        long starttime = System.currentTimeMillis();
        System.out.println("汽车开始行驶...");

        // 实现开车
        try {
            System.out.println("汽车行驶中...");
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//		long endtime = System.currentTimeMillis();
//		System.out.println("汽车结束行驶...汽车行驶时间："+(endtime - starttime) + "毫秒");
    }

}
