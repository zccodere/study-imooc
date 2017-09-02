package com.myimooc.designpattern.c5observer.weathercondition;

import java.util.Objects;

/**
 * @describe 天气目标的实现类
 * @author zc
 * @version 1.0 2017-08-29
 */
public class ConcreteWeatherSubject extends WeatherSubject {
	
	// 天气情况：晴天、下雨、下雪
	// 目标对象的状态
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
			if(Objects.equals("下雨", this.getWeatherContent())){
				if(Objects.equals("黄明的女朋友", observer.getObserverName())){
					observer.update(this);
				}
				if(Objects.equals("黄明的老妈", observer.getObserverName())){
					observer.update(this);
				}
			}
			
			// 如果天气是下雪
			if(Objects.equals("下雪", this.getWeatherContent())){
				if(Objects.equals("黄明的老妈", observer.getObserverName())){
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
