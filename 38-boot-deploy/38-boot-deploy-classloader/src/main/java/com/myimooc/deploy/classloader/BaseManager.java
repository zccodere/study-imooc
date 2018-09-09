package com.myimooc.deploy.classloader;

/**
 * @author zc
 * @version 1.0 2017-12-01
 * @title 标识接口
 * @describe 实现这个接口的子类需要动态更新
 */
public interface BaseManager {
    /**
     * 动态更新
     */
    void logic();

}
