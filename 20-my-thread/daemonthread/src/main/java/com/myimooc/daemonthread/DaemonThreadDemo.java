package com.myimooc.daemonthread;

import java.util.Scanner;

/**
 * 主线程
 * @author ZhangCheng on 2017-07-08
 *
 */
public class DaemonThreadDemo {

	public static void main(String[] args) {
		
		System.out.println("进入主线程" + Thread.currentThread().getName());
		
		DaemonThread daemonThread = new DaemonThread();
		Thread thread = new Thread(daemonThread);
		thread.setDaemon(true);
		thread.start();
		
		Scanner sc = new Scanner(System.in);
		sc.next();
		sc.close();
		
		System.out.println("退出主线程" + Thread.currentThread().getName());
		
	}

}
