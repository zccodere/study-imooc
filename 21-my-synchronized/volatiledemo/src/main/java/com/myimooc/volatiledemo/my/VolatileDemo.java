package com.myimooc.volatiledemo.my;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 程序主类
 * @author ZhangCheng on 2017-07-09
 *
 */
public class VolatileDemo {
	
	private int number = 0;
	private Lock lock = new ReentrantLock();
	
	public int getNumber(){
		return this.number;
	}
	
	public void increase(){
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// 方案一
		/*
		synchronized(this){
			this.number++;
		}
		*/
		// 方案二
		lock.lock();// 获取锁
		try {
			this.number++;
		} finally {
			lock.unlock();// 释放锁
		}
		
	}
	
	public static void main(String[] args) {
		final VolatileDemo volDemo = new VolatileDemo();
		for(int i = 0 ; i < 500 ; i++){
			new Thread(new Runnable() {
				@Override
				public void run() {
					volDemo.increase();
				}
			}).start();
		}
		
		//如果还有子线程在运行，主线程就让出CPU资源，
		//直到所有的子线程都运行完了，主线程再继续往下执行
		while(Thread.activeCount() > 1){
			Thread.yield();
		}
		
		System.out.println("number : " + volDemo.getNumber());
	}
	
}
