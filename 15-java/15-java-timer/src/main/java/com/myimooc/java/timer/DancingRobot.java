package com.myimooc.java.timer;

import java.text.SimpleDateFormat;
import java.util.TimerTask;

/**
 * 跳舞机器人
 *
 * @author zc 2017-05-24
 */
public class DancingRobot extends TimerTask {

    /**
     * 任务执行
     */
    @Override
    public void run() {

        // 获取最近的一次任务执行的时间并将其格式化
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.print("Scheduled exec time is : " + sf.format(scheduledExecutionTime()));

        System.out.println("Dancing happily!");
    }
}
