package com.myimooc.java.timer;

import java.util.concurrent.ScheduledFuture;

/**
 * 高级灌水机器人
 *
 * @author zc 2020-03-16
 */
public class HigherWaterRobot implements Runnable {

    private ScheduledFuture scheduledFuture;

    /**
     * 桶容量，最大容量为5
     */
    private Integer bucketCapacity = 0;

    @Override
    public void run() {
        // 灌水直至桶满为止
        int count = 5;
        if (this.bucketCapacity < count) {
            System.out.println("Add 1L water into the bucket!");
            bucketCapacity++;
        } else {
            System.out.println("The number of canceled task in timer is : " + scheduledFuture.toString());
            // 水满之后就停止执行
            scheduledFuture.cancel(true);
            System.out.println("The waterRobot has been aborted");
            System.out.println("The number of canceled task in timer is : " + scheduledFuture.toString());
            System.out.println("Current water is : " + bucketCapacity);
            // 等待两秒钟，终止timer里面的所有内容
            try {
                Thread.sleep(2000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            scheduledFuture.cancel(true);
        }
    }

    void setScheduledFuture(ScheduledFuture scheduledFuture) {
        this.scheduledFuture = scheduledFuture;
    }
}
