package com.myimooc.quartz.boot.quartz;

import org.quartz.JobExecutionContext;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 方式二：使用JobDetailFactoryBean 演示
 *
 * @author zc 2017-06-28
 */
public class FirstScheduledJob extends QuartzJobBean {

    private AnotherBean anotherBean;

    public void setAnotherBean(AnotherBean anotherBean) {
        this.anotherBean = anotherBean;
    }

    @Override
    protected void executeInternal(JobExecutionContext context) {
        Date date = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        System.out.println("FirstScheduledJob Execute!" + sf.format(date));
        this.anotherBean.printAnotherMessage();
    }

}
