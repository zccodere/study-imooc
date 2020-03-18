package com.myimooc.java.design.pattern.observer.weather;

/**
 * 具体的观察者对象，实现更新的方法，使自身的状态和目标的状态保持一致
 *
 * @author zc 2017-08-29
 */
public class ConcreteObserver implements Observer {

    /**
     * 观察者的名称，是谁收到了这个信息
     */
    private String observerName;

    /**
     * 天气的内容信息，这个消息从目标处获取
     */
    private String weatherContent;

    /**
     * 提醒的内容，不同的观察者提醒不同的内容
     */
    private String remindThing;

    /**
     * 获取目标类的状态同步到观察者的状态中
     */
    @Override
    public void update(WeatherSubject subject) {
        weatherContent = ((ConcreteWeatherSubject) subject).getWeatherContent();
        System.out.println(observerName + " 收到了天气信息  " + weatherContent + "，准备去做 " + remindThing);
    }

    public String getObserverName() {
        return observerName;
    }

    public void setObserverName(String observerName) {
        this.observerName = observerName;
    }

    public String getWeatherContent() {
        return weatherContent;
    }

    public void setWeatherContent(String weatherContent) {
        this.weatherContent = weatherContent;
    }

    public String getRemindThing() {
        return remindThing;
    }

    public void setRemindThing(String remindThing) {
        this.remindThing = remindThing;
    }
}
