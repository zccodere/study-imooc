package com.myimooc.quartz.hello.four;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.SimpleTrigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * SimpleTrigger 演示
 *
 * @author zc 2017-06-26
 */
public class HelloScheduler {

    public static void main(String[] args) throws SchedulerException {
        // 打印当前的执行时间，格式为2017-01-01 00:00:00
        Date date = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("Current Time Is : " + sf.format(date));

        // 创建一个 JobDetail 实例，将该实例与 HelloJob 实例绑定
        JobDetail jobDetail = JobBuilder.newJob(HelloJob.class)
                // 定义标识符
                .withIdentity("my-job", "job-group1")
                .build();

        // 获取距离当前时间4秒钟之后的具体时间
        date.setTime(date.getTime() + 4000);
        // 获取距离当前时间6秒钟之后的具体时间
        Date endDate = new Date();
        endDate.setTime(endDate.getTime() + 6000);

        // 距离当前时间4秒钟后首次执行任务，之后每隔2秒钟重复执行一次任务
        // 知道距离当前时间6秒钟之后为止
        SimpleTrigger trigger = TriggerBuilder
                .newTrigger()
                // 定义标识符
                .withIdentity("myTrigger", "tri-group1")
                .startAt(date)
                .endAt(endDate)
                .withSchedule(SimpleScheduleBuilder
                        .simpleSchedule()
                        .withIntervalInSeconds(2)
                        .withRepeatCount(SimpleTrigger.REPEAT_INDEFINITELY))
                .build();

        // 创建 Scheduler 实例
        SchedulerFactory factory = new StdSchedulerFactory();
        Scheduler scheduler = factory.getScheduler();
        scheduler.scheduleJob(jobDetail, trigger);
        scheduler.start();
    }
}
