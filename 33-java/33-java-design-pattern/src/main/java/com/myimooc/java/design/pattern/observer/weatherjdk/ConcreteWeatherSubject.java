package com.myimooc.java.design.pattern.observer.weatherjdk;

import java.util.Observable;

/**
 * 使用JDK实现观察者模式，天气目标具体实现类
 *
 * @author zc 2017-08-29
 */
public class ConcreteWeatherSubject extends Observable {

    /**
     * 天气情况的内容
     */
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
        // 天气情况有了，就要通知所有的观察者
        // 在用Java中的Observer模式时，需要先调用setChanged方法
        this.setChanged();

        // 调用通知方法-推模型
        this.notifyObservers(content);

        // 调用通知方法-拉模型
//		this.notifyObservers();
    }
}
