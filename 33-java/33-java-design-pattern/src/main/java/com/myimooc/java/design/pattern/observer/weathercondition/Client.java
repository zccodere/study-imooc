package com.myimooc.java.design.pattern.observer.weathercondition;

/**
 * 区别对待观察者测试类
 *
 * @author zc 2017-08-29
 */
public class Client {

    public static void main(String[] args) {
        // 1.创建目标
        ConcreteWeatherSubject weather = new ConcreteWeatherSubject();

        // 2.创建观察者
        ConcreteObserver observerGiel = new ConcreteObserver();
        observerGiel.setObserverName("黄明的女朋友");
        observerGiel.setRemindThing("下雨了，安静的呆在家里吧");

        ConcreteObserver observerMum = new ConcreteObserver();
        observerMum.setObserverName("黄明的老妈");
        observerMum.setRemindThing("不管下雨还是下雪，我都不出门了");

        // 3.注册观察者
        weather.attach(observerGiel);
        weather.attach(observerMum);

        // 4.目标发布天气
        weather.setWeatherContent("天气");
        weather.setWeatherContent("下雪");
        weather.setWeatherContent("下雨");
    }
}
