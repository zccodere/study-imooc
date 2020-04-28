package com.myimooc.java.design.pattern.observer.weathercondition;

import java.util.Objects;

/**
 * 天气目标的实现类
 *
 * @author zc 2017-08-29
 */
public class ConcreteWeatherSubject extends AbstractWeatherSubject {

    private static final String WEATHER_RAIN = "下雨";
    private static final String HM_GIRL_FRIEND = "黄明的女朋友";
    private static final String HM_MOM = "黄明的老妈";
    private static final String WEATHER_SNOW = "下雪";

    /**
     * 目标对象的状态（天气情况：晴天、下雨、下雪）
     */
    private String weatherContent;

    @Override
    protected void notifyObservers() {
        // 遍历所有注册的观察者
        this.observers.forEach(observer -> {
            // 规则是：
            // 黄明的女朋友 需要 下雨 的条件通知，其他条件不通知
            // 黄明的老妈 需要 下雨 或者 下雪 的条件通知，其他条件不通知

            // 如果天气是晴天
            // do nothing...

            // 如果天气是下雨
            if (Objects.equals(WEATHER_RAIN, this.getWeatherContent())) {
                if (Objects.equals(HM_GIRL_FRIEND, observer.getObserverName())) {
                    observer.update(this);
                }
                if (Objects.equals(HM_MOM, observer.getObserverName())) {
                    observer.update(this);
                }
            }

            // 如果天气是下雪
            if (Objects.equals(WEATHER_SNOW, this.getWeatherContent())) {
                if (Objects.equals(HM_MOM, observer.getObserverName())) {
                    observer.update(this);
                }
            }
        });
    }

    public String getWeatherContent() {
        return weatherContent;
    }

    public void setWeatherContent(String weatherContent) {
        this.weatherContent = weatherContent;
        this.notifyObservers();
    }
}
