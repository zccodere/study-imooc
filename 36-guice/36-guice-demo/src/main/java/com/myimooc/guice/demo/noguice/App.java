package com.myimooc.guice.demo.noguice;

/**
 * 启动类；改造HelloWorld类
 *
 * @author zc 2017-10-15
 */
public class App {

    /**
     * main方法的作用
     * <p>
     * bootstrap: parse command line：解析命令行参数； set up environment：配置环境参数； kick off main
     * logic：启动程序逻辑；
     * </p>
     */
    public static void main(String[] args) {
        MyApplet mainApplet = Configuration.getMainApplet();
        mainApplet.run();
    }
}
