package com.myimooc.deploy.classloader;

import java.util.concurrent.*;

/**
 * @author zc
 * @version 1.0 2017-12-01
 * @title 测试类
 * @describe 测试Java类的热加载
 */
public class ClassLoaderTest {

    public static void main(String[] args) {

        ThreadFactory threadFactory = Executors.defaultThreadFactory();

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 1, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(5), threadFactory);

        threadPoolExecutor.execute(new MsgHandler());

    }
}

