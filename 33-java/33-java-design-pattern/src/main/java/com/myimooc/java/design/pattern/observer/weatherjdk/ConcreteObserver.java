package com.myimooc.java.design.pattern.observer.weatherjdk;

import java.util.Observable;
import java.util.Observer;

/**
 * 使用JDK实现观察者模式，具体的观察者对象
 *
 * @author zc 2017-08-29
 */
public class ConcreteObserver implements Observer {

    /**
     * 观察者的名称，是谁收到了这个信息
     */
    private String observerName;

    @Override
    public void update(Observable o, Object arg) {

        // 推模型
        System.out.println(observerName + " 收到了消息，目标推送过来的是 " + arg);

        // 拉模型
        ConcreteWeatherSubject concreteWeatherSubject = (ConcreteWeatherSubject) o;
        System.out.println(observerName + " 收到了消息，主动到目标对象中去拉 " + concreteWeatherSubject.getContent());
    }

    public String getObserverName() {
        return observerName;
    }

    public void setObserverName(String observerName) {
        this.observerName = observerName;
    }

}
