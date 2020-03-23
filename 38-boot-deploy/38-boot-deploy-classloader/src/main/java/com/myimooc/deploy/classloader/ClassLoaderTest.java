package com.myimooc.deploy.classloader;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;

/**
 * 测试类；测试Java类的热加载
 *
 * @author zc 2017-12-01
 */
public class ClassLoaderTest {

    public static void main(String[] args) {

        ThreadFactory threadFactory = (runnable) -> {
            Thread thread = new Thread(runnable);
            thread.setName("daemon-pool-%d");
            thread.setDaemon(true);
            return thread;
        };
        ExecutorService executor = new ScheduledThreadPoolExecutor(1, threadFactory);

        executor.execute(new MsgHandler());

        Scanner sc = new Scanner(System.in);
        sc.next();
        sc.close();

        executor.shutdownNow();
        System.out.println("退出主线程" + Thread.currentThread().getName());
    }
}
