package com.myimooc.boot.start.tasks;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 定义定时任务
 *
 * @author zc 2018-04-26
 */
@Component
public class TestTask {

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("HH:mm:ss");

    /**
     * 定义每过3秒执行任务 支持使用 @Scheduled(cron = "4-40 * * * * ?") cron表达式
     */
    @Scheduled(fixedRate = 3000)
    public void reportCurrentTime() {
        System.out.println("现在时间：" + DATE_FORMAT.format(new Date()));
    }
}
