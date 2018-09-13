package com.myimooc.quartz.hello.five;

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

/**
 * CronTrigger 演示
 * @author ZhangCheng on 2017-06-26
 *
 */
public class HelloScheduler {
	
	public static void main(String[] args) throws SchedulerException {
		// 打印当前的执行时间，格式为2017-01-01 00:00:00
		Date date = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("Current Time Is : " + sf.format(date));
		
		// 创建一个 JobDetail 实例，将该实例与 HelloJob 实例绑定
		JobDetail jobDeatil = JobBuilder.newJob(HelloJob.class)
				// 定义标识符
				.withIdentity("myjob", "jobgroup1")
				.build();
		
		// 每秒钟触发一次任务
		CronTrigger trigger = (CronTrigger) TriggerBuilder
				.newTrigger()
				// 定义标识符
				.withIdentity("myTrigger","trigroup1")
				.withSchedule(CronScheduleBuilder
						.cronSchedule("* * * * * ? *"))
				.build();
		 
		// 1.2017年内每天10点15分触发一次
		// 0 15 10 ? * * 2017
		
		// 2.每天的14点整至14点59分55秒，以及18点整至18点59分55秒，每5秒钟触发一次
		// 0/5 * 14,18 * * ?
		
		// 3.每月周一至周五的10点15分触发一次
		// 0 15 10 ? 1-5
		
		// 4.每月最后一天的10点15分触发一次
		// 
		
		// 5.每月第三个周五的10点15分触发一次	
		// 
		
		// 创建 Scheduler 实例
		SchedulerFactory sfact = new StdSchedulerFactory();
		Scheduler scheduler = sfact.getScheduler();
		scheduler.scheduleJob(jobDeatil, trigger);
		scheduler.start();
	}
	
}
