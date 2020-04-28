package com.myimooc.thread.ticket.thread;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;

/**
 * 主类-启动线程类
 *
 * @author zc 2017-07-08
 */
public class TicketsThread {

    public static void main(String[] args) {

        // 使用线程池
        ThreadFactory threadFactory1 = new ThreadFactoryBuilder().setNameFormat("window-pool-%d").build();
        ExecutorService executor = new ScheduledThreadPoolExecutor(3, threadFactory1);

        // 启用三个窗口卖票
        int count = 3;
        for (int i = 0; i < count; i++) {
            executor.execute(new MyThread("窗口" + i));
        }
        executor.shutdown();

//		创建三个线程，模拟三个窗口卖票
//		MyThread mt1 = new MyThread("窗口1");
//		MyThread mt2 = new MyThread("窗口2");
//		MyThread mt3 = new MyThread("窗口3");
//
//		启动这三个线程，即窗口开始卖票
//		mt1.start();
//		mt2.start();
//		mt3.start();
    }

}
