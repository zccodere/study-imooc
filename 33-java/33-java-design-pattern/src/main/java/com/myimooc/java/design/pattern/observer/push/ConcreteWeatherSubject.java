package com.myimooc.java.design.pattern.observer.push;

/**
 * 具体的目标对象，负责把有关状态存入到相应的观察者对象中
 *
 * @author zc 2017-08-29
 */
public class ConcreteWeatherSubject extends WeatherSubject {

    /**
     * 获取天气的内容信息
     */
    private String weatherContent;

    public String getWeatherContent() {
        return weatherContent;
    }

    public void setWeatherContent(String weatherContent) {
        this.weatherContent = weatherContent;
        // 内容有了，说明天气更新了，通知所有订阅的人
        this.notifyObserver(weatherContent);
    }
}
