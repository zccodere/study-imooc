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

        ExecutorService executor = Executors.newSingleThreadExecutor();

        executor.execute(new MsgHandler());

    }
}

