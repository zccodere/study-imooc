package com.myimooc.deploy.classloader;

/**
 * 标识接口；实现这个接口的子类需要动态更新
 *
 * @author zc 2017-12-01
 */
public interface BaseManager {

    /**
     * 动态更新
     */
    void logic();

}
