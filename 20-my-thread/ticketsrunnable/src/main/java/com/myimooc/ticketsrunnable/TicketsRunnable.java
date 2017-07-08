package com.myimooc.ticketsrunnable;

/**
 * 主类-启动线程类
 * @author ZhangCheng on 2017-07-08
 *
 */
public class TicketsRunnable {
	
	public static void main(String[] args) {
		
		MyThread mt = new MyThread();
		
		// 创建三个线程，模拟三个窗口卖票
		Thread th1 = new Thread(mt,"窗口1");
		Thread th2 = new Thread(mt,"窗口2");
		Thread th3 = new Thread(mt,"窗口3");
		
		// 启动这三个线程，即窗口开始卖票
		th1.start();
		th2.start();
		th3.start();
		
	}
	
}
