package com.imooc.demo.HelloQuartz;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class HelloScheduler {
	public static void main(String[] args) throws SchedulerException, InterruptedException {
		// 打印当前的时间，格式为2017-01-01 00:00:00
		Date date = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("Current Time Is : " + sf.format(date));
		// 创建一个JobDetail实例，将该实例与HelloJob Class绑定
		JobDetail jobDetail = JobBuilder.newJob(HelloJob.class)
				.withIdentity("myJob").build();
		CronTrigger trigger = (CronTrigger) TriggerBuilder
				.newTrigger()
				.withIdentity("myTrigger", "group1")
				.withSchedule(
						CronScheduleBuilder.cronSchedule("* * * * * ?"))
				.build();
		// 创建Scheduler实例
		SchedulerFactory sfact = new StdSchedulerFactory();
		Scheduler scheduler = sfact.getScheduler();
		scheduler.start();
		System.out.println("scheduled time is :"
				+ sf.format(scheduler.scheduleJob(jobDetail, trigger)));
		//scheduler执行两秒后挂起
		Thread.sleep(2000L);		
		//shutdown(true)表示等待所有正在执行的job执行完毕之后，再关闭scheduler
		//shutdown(false)即shutdown()表示直接关闭scheduler
		scheduler.shutdown(false);
		System.out.println("scheduler is shut down? " + scheduler.isShutdown());
	}
}
