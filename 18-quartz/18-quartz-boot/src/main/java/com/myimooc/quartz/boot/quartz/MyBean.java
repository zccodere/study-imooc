package com.myimooc.quartz.boot.quartz;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

/**
 * 方式一：使用MethodInvokingJobDetailFactoryBean 演示
 * @author ZhangCheng on 2017-06-28
 *
 */
@Component
public class MyBean {
	
	public void printMessage(){
		
		// 打印当前的执行时间，格式为2017-01-01 00:00:00
		Date date = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		System.out.println("MyBean Executes!" + sf.format(date));
	}
	
}
