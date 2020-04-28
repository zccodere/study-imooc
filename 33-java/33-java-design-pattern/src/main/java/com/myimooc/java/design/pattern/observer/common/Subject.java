package com.myimooc.java.design.pattern.observer.common;

import java.util.ArrayList;
import java.util.List;

/**
 * 目标类，目标对象，它知道观察它的观察者，并提供注册（添加）和删除观察者的接口
 *
 * @author zc 2017-08-29
 */
public class Subject {

    /**
     * 用来保证注册的观察者对象
     */
    private List<Observer> observers = new ArrayList<>();

    /**
     * 增加观察者
     */
    public void attach(Observer observer) {
        observers.add(observer);
    }

    /**
     * 删除指定的观察者
     */
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    /**
     * 通过所有注册的观察者对象
     */
    protected void notifyObserver() {
        observers.forEach(observer -> {
            observer.update(this);
        });
    }
}
