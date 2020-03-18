package com.myimooc.java.design.pattern.observer.weathercondition;

/**
 * 观察者接口，定义一个更新的接口给那些在目标对象发生改变的时候被通知的对象
 *
 * @author zc 2017-08-29
 */
public interface Observer {

    /**
     * 更新的接口
     *
     * @param subject 传入的目标对象，方便获取相应的目标对象的状态
     */
    void update(AbstractWeatherSubject subject);

    /**
     * 设置观察者名称
     *
     * @param observerName 观察者名称
     */
    void setObserverName(String observerName);

    /**
     * 获取观察者名称
     *
     * @return 观察者名称
     */
    String getObserverName();
}
