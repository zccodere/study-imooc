package com.myimooc.java.timer;

import org.apache.commons.lang3.concurrent.BasicThreadFactory;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Timer;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 机器人执行类
 * <p>Timer 已经过时，请使用 ScheduledExecutorService 代替 Timer</p>
 * <p>如想要查看运行效果，放开下面注释即可</p>
 *
 * @author zc 2017-05-24
 */
public class RobotExecutor {

    public static void main(String[] args) throws Exception {
        executeByExecutor();
    }

    private static void executeByExecutor() throws Exception {
        // 使用 commons-lang3 提供的工具类创建线程工厂
        BasicThreadFactory threadFactory = new BasicThreadFactory.Builder().namingPattern("robot-schedule-pool-%d").daemon(true).build();
        ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(3, threadFactory);

        DancingRobot dancingRobot = new DancingRobot();
        HigherWaterRobot waterRobot = new HigherWaterRobot();

        // 跳舞机器人延迟0秒执行，之后每隔2秒执行一次
        executorService.scheduleAtFixedRate(dancingRobot, 0, 2, TimeUnit.SECONDS);

        // 跳舞机器人延迟3秒执行，之后每隔1秒执行一次
        ScheduledFuture<?> scheduledFuture = executorService.scheduleWithFixedDelay(waterRobot, 3, 1, TimeUnit.SECONDS);
        waterRobot.setScheduledFuture(scheduledFuture);

        // 主线程休眠20秒，让定时任务线程池执行，以方便查看运行效果
        TimeUnit.SECONDS.sleep(20);

        // 手动关闭线程池
        executorService.shutdownNow();
    }
/*
    @Deprecated
    private static void executeByTimer() {
        Timer timer = new Timer();
        // 获取当前时间
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("Current time is : " + sf.format(calendar.getTime()));

        DancingRobot dancingRobot = new DancingRobot();
        WaterRobot waterRobot = new WaterRobot(timer);

        timer.schedule(dancingRobot, calendar.getTime(), 2000L);
        timer.scheduleAtFixedRate(waterRobot, calendar.getTime(), 1000L);
    }*/
}
