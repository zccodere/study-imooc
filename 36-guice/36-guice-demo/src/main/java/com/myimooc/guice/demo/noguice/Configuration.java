package com.myimooc.guice.demo.noguice;

import com.myimooc.guice.demo.noguice.helloworlddemo.PrintStreamWriter;
import com.myimooc.guice.demo.noguice.helloworlddemo.StringProvider;
import com.myimooc.guice.demo.noguice.helloworlddemo.StringWritingApplet;

/**
 * 程序启动配置类
 *
 * @author zc 2017-10-15
 */
public class Configuration {

    public static MyApplet getMainApplet() {
        return new StringWritingApplet(
                new PrintStreamWriter(System.out),
                new StringProvider() {
                    @Override
                    public String get() {
                        return "Hello World";
                    }
                });
    }
}
