package com.myimooc.java.timer;

import org.apache.commons.lang3.concurrent.BasicThreadFactory;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 取消定时任务
 * <p>Timer 已经过时，请使用 ScheduledExecutorService 代替 Timer</p>
 * <p>如想要查看运行效果，放开下面注释即可</p>
 *
 * @author zc 2017-05-24
 */
public class CancelTest {

    public static void main(String[] args) throws Exception {
        executeByExecutor();
    }

    private static void executeByExecutor() throws Exception {
        // 使用 commons-lang3 提供的工具类创建线程工厂
        BasicThreadFactory threadFactory = new BasicThreadFactory.Builder().namingPattern("my-task-example-schedule-pool-%d").daemon(true).build();
        ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(2, threadFactory);

        // 创建TimerTask实例
        MyTimerTask task1 = new MyTimerTask("task1");
        MyTimerTask task2 = new MyTimerTask("task2");

        // task1首次执行是距离现在时间3秒后执行，之后每隔2秒执行一次
        ScheduledFuture<?> scheduledFuture = executorService.scheduleWithFixedDelay(task1, 3, 2, TimeUnit.SECONDS);
        scheduledFuture.cancel(true);

        // task1首次执行是距离现在时间1秒后执行，之后每隔2秒执行一次
        executorService.scheduleWithFixedDelay(task2, 1, 2, TimeUnit.SECONDS);

        // 主线程休眠20秒，让定时任务线程池执行，以方便查看运行效果
        TimeUnit.SECONDS.sleep(20);

        // 因为使用了线程池，所以MyTimerTask类中的run方法执行了TimerTask类的cancel()方法并不会生效，所以这里手动关闭线程池
        executorService.shutdownNow();
    }
/*
    @Deprecated
    private static void executeByTimer() throws InterruptedException {
        // 创建Timer实例
        Timer timer = new Timer();
        // 创建TimerTask实例
        MyTimerTask task1 = new MyTimerTask("task1");
        MyTimerTask task2 = new MyTimerTask("task2");
        // 获取当前的执行时间并打印
        Date startTime = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("start time is : " + simpleDateFormat.format(startTime));
        // task1首次执行是距离现在时间3秒后执行，之后每隔2秒执行一次
        // task1首次执行是距离现在时间1秒后执行，之后每隔2秒执行一次
        timer.schedule(task1, 3000L, 2000L);
        timer.schedule(task2, 1000L, 2000L);
        System.out.println("current canceled task number is : " + timer.purge());
        // 休眠5秒
        Thread.sleep(2000L);
        // 获取当前的执行时间并打印
        Date cancelTime = new Date();
        System.out.println("cancel time is : " + simpleDateFormat.format(cancelTime));

        // 取消所有任务
        boolean isCancelAll = false;
        if (isCancelAll) {
            timer.cancel();
            System.out.println("Tasks all canceled!");
        }

        task2.cancel();

        System.out.println("current canceled task number is : " + timer.purge());
    }*/
}
