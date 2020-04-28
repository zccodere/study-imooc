package com.myimooc.java.timer;

import java.util.TimerTask;

/**
 * 灌水机器人
 * <p>Timer 已经过时，如想要查看运行效果，放开下面注释即可</p>
 *
 * @author zc 2017-05-24
 */
public class WaterRobot extends TimerTask {

    @Override
    public void run() {
        // 什么也不做，如果要查看运行效果，请注释该方法
    }

/*
    private Timer timer;

    private Integer bucketCapacity = 0;

    WaterRobot(Timer timer) {
        this.timer = timer;
    }

    @Override
    public void run() {
        // 灌水直至桶满为止
        int count = 5;
        if (this.bucketCapacity < count) {
            System.out.println("Add 1L water into the bucket!");
            bucketCapacity++;
        } else {
            System.out.println("The number of canceled task in timer is : " + timer.purge());
            // 水满之后就停止执行
            cancel();
            System.out.println("The waterRobot has been aborted");
            System.out.println("The number of canceled task in timer is : " + timer.purge());
            System.out.println("Current water is : " + bucketCapacity);
            // 等待两秒钟，终止timer里面的所有内容
            try {
                Thread.sleep(2000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            timer.cancel();
        }
    }*/
}
