package com.myimooc.guice.demo.noguice.helloworlddemo;

import com.myimooc.guice.demo.noguice.MyApplet;

/**
 * 提供打印HelloWorld的功能
 *
 * @author zc 2017-10-15
 */
public class StringWritingApplet implements MyApplet {

    private MyDestination destination;
    private StringProvider stringProvider;

    public StringWritingApplet(MyDestination destination, StringProvider stringProvider) {
        super();
        this.destination = destination;
        this.stringProvider = stringProvider;
    }

    private void writeString() {
        destination.write(stringProvider.get());
    }

    @Override
    public void run() {
        writeString();
    }
}
