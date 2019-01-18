package com.myimooc.spring.simple.ioc.interfaces;

/**
 * <br>
 * 标题: 接口实现<br>
 * 描述: 一个接口实现<br>
 * 时间: 2017/01/18<br>
 *
 * @author zc
 */
public class OneInterfaceImpl implements OneInterface {

    @Override
    public void say(String arg) {
        System.out.println("ServiceImpl say: " + arg);
    }

}
