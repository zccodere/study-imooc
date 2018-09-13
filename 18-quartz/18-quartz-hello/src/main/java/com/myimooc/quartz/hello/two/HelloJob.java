package com.myimooc.quartz.hello.two;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;
import org.quartz.TriggerKey;

/**
 * 编写 自定义任务
 * @author ZhangCheng on 2017-06-26
 *
 */
public class HelloJob implements Job{
	
	// 方式二：getter和setter获取
	/**
	 * 成员变量 与 传入参数的key一致
	 */
	private String message;
	private Float floatJobValue;
	private Double doubleTriggerValue;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Float getFloatJobValue() {
		return floatJobValue;
	}
	public void setFloatJobValue(Float floatJobValue) {
		this.floatJobValue = floatJobValue;
	}
	public Double getDoubleTriggerValue() {
		return doubleTriggerValue;
	}
	public void setDoubleTriggerValue(Double doubleTriggerValue) {
		this.doubleTriggerValue = doubleTriggerValue;
	}
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		// 打印当前的执行时间，格式为2017-01-01 00:00:00
		Date date = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("Current Exec Time Is : " + sf.format(date));
		
		// 编写具体的业务逻辑
		System.out.println("Hello World!");
		
		JobKey key = context.getJobDetail().getKey();
		System.out.println("My name and group are : " + key.getName() + " : " + key.getGroup());
		
		TriggerKey trkey = context.getTrigger().getKey();
		System.out.println("My Trigger name and group are : " + trkey.getName() + " : " + trkey.getGroup());
		
		// 方式一：Map中直接  获取自定义参数
		JobDataMap jdataMap = context.getJobDetail().getJobDataMap();
		JobDataMap tdataMap = context.getTrigger().getJobDataMap();
		String jobMsg = jdataMap.getString("message");
		Float jobFloatValue = jdataMap.getFloat("floatJobValue");
		
		String triMsg = tdataMap.getString("message");
		Double triDoubleValue = tdataMap.getDouble("doubleTriggerValue");
		
		System.out.println("jobMsg is : " + jobMsg);
		System.out.println("jobFloatValue is : " + jobFloatValue);
		System.out.println("triMsg is : " + triMsg);
		System.out.println("triDoubleValue is : " + triDoubleValue);
		
		// 方式一：Map中直接获取 获取自定义参数
		JobDataMap jobDataMap = context.getMergedJobDataMap();
		jobMsg = jobDataMap.getString("message");
		jobFloatValue = jobDataMap.getFloat("floatJobValue");
		
		triMsg = jobDataMap.getString("message");
		triDoubleValue = jobDataMap.getDouble("doubleTriggerValue");
		
		System.out.println("jobMsg is : " + jobMsg);
		System.out.println("jobFloatValue is : " + jobFloatValue);
		System.out.println("triMsg is : " + triMsg);
		System.out.println("triDoubleValue is : " + triDoubleValue);
		
		// 方式二：getter和setter获取
		System.out.println("message is : " + this.message);
		System.out.println("jobFloatValue is : " + this.floatJobValue);
		System.out.println("triDoubleValue is : " + this.doubleTriggerValue);
	}
	
}
