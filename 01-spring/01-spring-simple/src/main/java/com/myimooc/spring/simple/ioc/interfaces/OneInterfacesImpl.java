package com.myimooc.spring.simple.ioc.interfaces;

/**
 * 另外一个实现
 *
 * @author zc 2017-01-18
 */
public class OneInterfacesImpl implements OneInterface {

    public String hello(String word) {
        return "Word form interfaces\"OneInterface\":" + word;
    }

    @Override
    public void say(String arg) {
        System.out.println("OneInterfacesImpl say：" + arg);
    }

}
