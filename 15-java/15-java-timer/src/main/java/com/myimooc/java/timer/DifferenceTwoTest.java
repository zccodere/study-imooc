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
public class DifferenceTwoTest {

    public static void main(String[] args){
        // 定义时间格式
        final SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // 获取当前的具体时间
        Calendar calendar = Calendar.getInstance();
        System.out.println("Current time is : " + sf.format(calendar.getTime()));
        Timer timer = new Timer();
        //timer.schedule(new TimerTask() {
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // 打印最近一次的计划执行时间
                System.out.println("Schedule exec time is : " + sf.format(scheduledExecutionTime()));
                System.out.println("Task is being executed!");
            }
        }, calendar.getTime(), 2000);
    }

}
