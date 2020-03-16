package com.myimooc.thread.daemon;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;

/**
 * 主线程
 *
 * @author zc 2017-07-08
 */
public class DaemonThreadDemo {

    public static void main(String[] args) {
        System.out.println("进入主线程" + Thread.currentThread().getName());

        ThreadFactory threadFactory1 = new ThreadFactoryBuilder().setNameFormat("daemon-pool-%d").build();
        ExecutorService executor = new ScheduledThreadPoolExecutor(1, threadFactory1);

        executor.execute(new DaemonThread());

        Scanner sc = new Scanner(System.in);
        sc.next();
        sc.close();

        executor.shutdownNow();
        System.out.println("退出主线程" + Thread.currentThread().getName());
    }
}
