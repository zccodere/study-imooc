package com.myimooc.thread.ticket.runnable;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;

/**
 * 主类-启动线程类
 *
 * @author zc 2017-07-08
 */
public class TicketsRunnable {

    public static void main(String[] args) {

        MyThread mt = new MyThread();

        // 使用线程池
        ThreadFactory threadFactory1 = new ThreadFactoryBuilder().setNameFormat("window-pool-%d").build();
        ExecutorService executor = new ScheduledThreadPoolExecutor(3, threadFactory1);

        // 启用三个窗口卖票
        int count = 3;
        for (int i = 0; i < count; i++) {
            executor.execute(mt);
        }
        executor.shutdown();

//      创建三个线程，模拟三个窗口卖票
//
//		Thread th1 = new Thread(mt,"窗口1");
//		Thread th2 = new Thread(mt,"窗口2");
//		Thread th3 = new Thread(mt,"窗口3");
//
//		// 启动这三个线程，即窗口开始卖票
//		th1.start();
//		th2.start();
//		th3.start();
//
    }

}
