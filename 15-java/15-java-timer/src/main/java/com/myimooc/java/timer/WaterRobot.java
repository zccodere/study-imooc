package com.myimooc.java.timer;

import java.util.Timer;
import java.util.TimerTask;

/**
 * <br>
 * 标题: 灌水机器人<br>
 * 描述: 灌水机器人<br>
 * 时间: 2017/05/24<br>
 *
 * @author zc
 */
public class WaterRobot extends TimerTask{

    private Timer timer;

    /**
     * 桶容量，最大容量为5
     */
    private Integer bucketCapacity = 0;

    public WaterRobot(Timer timer){
        this.timer = timer;
    }

    @Override
    public void run() {
        // 灌水直至桶满为止
        int count = 5;
        if (this.bucketCapacity < count) {
            System.out.println("Add 1L water into the bucket!");
            bucketCapacity++;
        }else{
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

    }
}
