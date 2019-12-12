package com.imooc.demo.HelloQuartz;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Hello world!
 * 
 */
public class App {
	public static void main(String[] args) {
		Date date = new Date();
		
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("Current Time Is : " + sf.format(date));
		date.setTime(date.getTime() + 3000);
		System.out.println("Current Time Is : " + sf.format(date));
	}
}
