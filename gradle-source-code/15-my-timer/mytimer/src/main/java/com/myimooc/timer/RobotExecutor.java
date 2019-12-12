package com.myimooc.timer;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Timer;

/**
 * 机器人执行类
 * Created by ChangComputer on 2017/5/24.
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
