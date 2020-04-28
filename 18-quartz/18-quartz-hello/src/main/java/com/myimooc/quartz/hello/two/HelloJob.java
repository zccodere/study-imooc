package com.myimooc.quartz.hello.two;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobKey;
import org.quartz.TriggerKey;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 编写 自定义任务
 *
 * @author zc 2017-06-26
 */
public class HelloJob implements Job {

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
    public void execute(JobExecutionContext context) {
        // 打印当前的执行时间，格式为2017-01-01 00:00:00
        Date date = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("Current Exec Time Is : " + sf.format(date));

        // 编写具体的业务逻辑
        System.out.println("Hello World!");

        JobKey key = context.getJobDetail().getKey();
        System.out.println("My name and group are : " + key.getName() + " : " + key.getGroup());

        TriggerKey triggerKey = context.getTrigger().getKey();
        System.out.println("My Trigger name and group are : " + triggerKey.getName() + " : " + triggerKey.getGroup());

        // 方式一：Map中直接  获取自定义参数
        JobDataMap jobDataMap = context.getJobDetail().getJobDataMap();
        JobDataMap triDataMap = context.getTrigger().getJobDataMap();
        String jobMsg = jobDataMap.getString("message");
        float jobFloatValue = jobDataMap.getFloat("floatJobValue");

        String triMsg = triDataMap.getString("message");
        double triDoubleValue = triDataMap.getDouble("doubleTriggerValue");

        System.out.println("jobMsg is : " + jobMsg);
        System.out.println("jobFloatValue is : " + jobFloatValue);
        System.out.println("triMsg is : " + triMsg);
        System.out.println("triDoubleValue is : " + triDoubleValue);

        // 方式一：Map中直接获取 获取自定义参数
        JobDataMap mergedJobDataMap = context.getMergedJobDataMap();
        jobMsg = mergedJobDataMap.getString("message");
        jobFloatValue = mergedJobDataMap.getFloat("floatJobValue");

        triMsg = mergedJobDataMap.getString("message");
        triDoubleValue = mergedJobDataMap.getDouble("doubleTriggerValue");

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
