package com.myimooc.guice.demo.bind;

import com.google.inject.Guice;
import com.google.inject.Injector;

import com.myimooc.guice.demo.bind.helloworlddemo.CommandLineModule;

/**
 * 启动类；改造HelloWorld类
 *
 * @author zc 2017-10-15
 */
public class App {

    /**
     * main方法的作用
     * <p>
     * bootstrap: parse command line：解析命令行参数 set up environment：配置环境参数 kick off main logic：启动程序逻辑
     * </p>
     */
    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new MainModule(), new CommandLineModule(args));
        Applets.get(injector, args[0]).run();
    }
}
