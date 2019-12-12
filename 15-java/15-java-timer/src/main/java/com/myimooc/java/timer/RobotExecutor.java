package com.myimooc.java.timer;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Timer;

/**
 * <br>
 * 标题: 机器人执行类<br>
 * 描述: 机器人执行类<br>
 * 时间: 2017/05/24<br>
 *
 * @author zc
 */
public class RobotExecutor {

    public static void main(String[] args){

        Timer timer = new Timer();

        // 获取当前时间
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("Current time is : " + sf.format(calendar.getTime()));

        DancingRobot dancingRobot = new DancingRobot();
        WaterRobot waterRobot = new WaterRobot(timer);

        timer.schedule(dancingRobot,calendar.getTime(),2000L);
        timer.scheduleAtFixedRate(waterRobot,calendar.getTime(),1000L);




    }

}
