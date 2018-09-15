package com.myimooc.java.timer;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

/**
 * <br>
 * 标题: schedule和scheduleAtFixedRate的区别 测试类<br>
 * 描述: schedule和scheduleAtFixedRate的区别 测试类<br>
 * 时间: 2017/05/24<br>
 *
 * @author zc
 */
public class DifferenceTest {

    public static void main(String[] args){
        // 定义时间格式
        final SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // 获取当前的具体时间
        Calendar calendar = Calendar.getInstance();

        System.out.println("Current time is : " + sf.format(calendar.getTime()));
        // 设置成6秒前的时间，若当前时间为2016-12-28 00:00:06
        // 那么设置之后时间变成2016-12-28 00:00:00
        calendar.add(Calendar.SECOND,-6);

        Timer timer = new Timer();

        // 第一次执行时间为6秒前，之后每隔两秒钟执行一次
        //timer.schedule(new TimerTask() {
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                // 打印最近一次的计划执行时间
                System.out.println("Schedule exec time is : " + sf.format(scheduledExecutionTime()));
                System.out.println("Task is being executed!");
            }
        }, calendar.getTime(), 2000);

    }

}
