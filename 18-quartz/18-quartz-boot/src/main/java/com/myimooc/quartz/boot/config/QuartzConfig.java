package com.myimooc.quartz.boot.config;

import com.myimooc.quartz.boot.quartz.AnotherBean;
import com.myimooc.quartz.boot.quartz.FirstScheduledJob;
import com.myimooc.quartz.boot.quartz.MyBean;

import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;

/**
 * Quartz 配置类
 *
 * @author zc 2017-06-28
 */
@Configuration
public class QuartzConfig {

    @Autowired
    private MyBean myBean;
    @Autowired
    private AnotherBean anotherBean;

    /**
     * 方式一：使用MethodInvokingJobDetailFactoryBean
     */
    @Bean
    public MethodInvokingJobDetailFactoryBean methodInvokingJobDetailFactoryBean() {
        MethodInvokingJobDetailFactoryBean mb = new MethodInvokingJobDetailFactoryBean();
        // 指定要运行的类
        mb.setTargetObject(myBean);
        // 指定要允许类中的那个方法
        mb.setTargetMethod("printMessage");
        return mb;
    }

    /**
     * 方式二：使用JobDetailFactoryBean
     */
    @Bean
    public JobDetailFactoryBean jobDetailFactoryBean() {
        JobDetailFactoryBean jb = new JobDetailFactoryBean();
        // 指定要运行的类
        jb.setJobClass(FirstScheduledJob.class);
        JobDataMap jobDataMap = new JobDataMap();
        jobDataMap.put("anotherBean", anotherBean);
        // 设置传入自定义参数
        jb.setJobDataMap(jobDataMap);
        jb.setDurability(true);
        return jb;
    }

    /**
     * 配置 SimpleTriggerFactoryBean
     */
    @Bean
    public SimpleTriggerFactoryBean simpleTriggerFactoryBean() {
        SimpleTriggerFactoryBean sb = new SimpleTriggerFactoryBean();
        // 设置需要绑定的 jobDetail
        sb.setJobDetail(methodInvokingJobDetailFactoryBean().getObject());
        // 距离当前时间1秒后执行
        sb.setStartDelay(1000L);
        // 之后每隔2秒执行一次
        sb.setRepeatInterval(2000L);
        return sb;
    }

    /**
     * 配置 SimpleTriggerFactoryBean
     */
    @Bean
    public CronTriggerFactoryBean cronTriggerFactoryBean() {
        CronTriggerFactoryBean cb = new CronTriggerFactoryBean();
        // 设置需要绑定的 jobDetail
        cb.setJobDetail(jobDetailFactoryBean().getObject());
        // 距离当前时间1秒后执行
        cb.setStartDelay(1000L);
        // 设置 Cron 表达式，之后每隔5秒执行一次
        cb.setCronExpression("0/5 * * ? * *");
        return cb;
    }

    /**
     * 配置 SchedulerFactoryBean
     */
    @Bean
    public SchedulerFactoryBean schedulerFactoryBean() {
        SchedulerFactoryBean sb = new SchedulerFactoryBean();
        // 配置 JobDetails
        JobDetail[] jobDetails = new JobDetail[2];
        jobDetails[0] = methodInvokingJobDetailFactoryBean().getObject();
        jobDetails[1] = jobDetailFactoryBean().getObject();
        sb.setJobDetails(jobDetails);

        // 配置 Trigger
        Trigger[] triggers = new Trigger[2];
        triggers[0] = simpleTriggerFactoryBean().getObject();
        triggers[1] = cronTriggerFactoryBean().getObject();
        sb.setTriggers(triggers);
        return sb;
    }
}
