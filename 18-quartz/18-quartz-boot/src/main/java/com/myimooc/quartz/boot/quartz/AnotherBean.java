package com.myimooc.quartz.boot.quartz;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

/**
 * 方式二：使用JobDetailFactoryBean 演示
 * @author ZhangCheng on 2017-06-28
 *
 */
@Component
public class AnotherBean {
	
	public void printAnotherMessage(){
		Date date = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		System.out.println("I am AnotherBean." + sf.format(date));
	}
	
}
