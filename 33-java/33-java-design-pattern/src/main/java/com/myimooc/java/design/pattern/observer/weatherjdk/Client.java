package com.myimooc.java.design.pattern.observer.weatherjdk;

/**
 * 使用JDK实现观察者模式，测试类
 *
 * @author zc 2017-08-29
 */
public class Client {

    public static void main(String[] args) {
        // 创建天气作为一个目标，也可以说是被观察者
        ConcreteWeatherSubject subject = new ConcreteWeatherSubject();

        // 创建黄明的女朋友作为观察者
        ConcreteObserver observerGirl = new ConcreteObserver();
        observerGirl.setObserverName("黄明的女朋友");

        // 创建黄明的老妈作为观察者
        ConcreteObserver observerMum = new ConcreteObserver();
        observerMum.setObserverName("老妈");

        // 注册观察者
        subject.addObserver(observerGirl);
        subject.addObserver(observerMum);

        // 目标更新天气情况
        subject.setContent("明天 天气晴朗，蓝天白云，气温28℃");
    }
}
