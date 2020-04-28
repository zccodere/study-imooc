package com.myimooc.java.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 程序主类
 *
 * @author zc 2017-07-09
 */
public class VolatileDemo {

    private int number = 0;
    private Lock lock = new ReentrantLock();

    private int getNumber() {
        return this.number;
    }

    private void increase() {

        // 方案一
		/*
		synchronized(this){
			this.number++;
		}
		*/
        // 方案二
        // 获取锁
        lock.lock();
        try {
            this.number++;
        } finally {
            // 释放锁
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        final VolatileDemo volDemo = new VolatileDemo();
        int count = 500;

        // 自定义线程池。因为 Executors.newFixedThreadPool(500) 存在 OOM 风险
        ThreadFactory threadFactory = Executors.defaultThreadFactory();
        ExecutorService executor = new ThreadPoolExecutor(500, 500, 0, TimeUnit.SECONDS, new LinkedBlockingDeque<>(100), threadFactory);

        for (int i = 0; i < count; i++) {
            // 使用 JDK8 的 Lambda 表达式
            executor.execute(volDemo::increase);
        }
        executor.shutdown();

        // 如果还有子线程在运行，主线程就让出CPU资源；直到所有的子线程都运行完了，主线程再继续往下执行
        while (Thread.activeCount() > 1) {
            Thread.yield();
        }

        System.out.println("number : " + volDemo.getNumber());
    }
}
