package com.myimooc.quartz.hello.two;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 编写 任务调度类
 *
 * @author zc 2017-06-26
 */
public class HelloScheduler {

    public static void main(String[] args) throws SchedulerException {

        // 创建一个 JobDetail 实例，将该实例与 HelloJob 实例绑定
        JobDetail jobDetail = JobBuilder.newJob(HelloJob.class)
                // 定义标识符
                .withIdentity("my-job", "job-group1")
                // 传入自定义参数
                .usingJobData("message", "hello my-job1")
                // 传入自定义参数
                .usingJobData("floatJobValue", 3.14F)
                .build();

        System.out.println("jobDetail's name : " + jobDetail.getKey().getName());
        System.out.println("jobDetail's group : " + jobDetail.getKey().getGroup());
        System.out.println("jobDetail's jobClass : " + jobDetail.getJobClass().getName());

        // 创建一个 Trigger 实例，定义该 job 立即执行，并且每隔两秒重复执行一次，直到永远
        Trigger trigger = TriggerBuilder.newTrigger()
                // 定义标识符
                .withIdentity("myTrigger", "tri-group1")
                // 传入自定义参数
                .usingJobData("message", "hello my-trigger1")
                // 传入自定义参数
                .usingJobData("doubleTriggerValue", 2.0D)
                // 定义立即执行
                .startNow()
                .withSchedule(SimpleScheduleBuilder
                        .simpleSchedule()
                        .withIntervalInSeconds(2)
                        // 定义执行频度
                        .repeatForever())
                .build();

        // 创建 Scheduler 实例
        SchedulerFactory factory = new StdSchedulerFactory();
        Scheduler scheduler = factory.getScheduler();
        // 绑定 JobDetail 和 trigger
        scheduler.scheduleJob(jobDetail, trigger);
        // 执行任务
        scheduler.start();
        // 打印当前的执行时间，格式为2017-01-01 00:00:00
        Date date = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("Current Time Is : " + sf.format(date));
    }
}
