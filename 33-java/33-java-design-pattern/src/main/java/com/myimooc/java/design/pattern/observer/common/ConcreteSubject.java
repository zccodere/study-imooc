package com.myimooc.java.design.pattern.observer.common;

/**
 * 具体的目标对象，负责把有关状态存入到相应的观察者对象中
 *
 * @author zc 2017-08-29
 */
public class ConcreteSubject extends Subject {

    /**
     * 目标对象的状态
     */
    private String subjectState;

    public String getSubjectState() {
        return subjectState;
    }

    public void setSubjectState(String subjectState) {
        this.subjectState = subjectState;
        // 当状态发生改变时，通知观察者
        super.notifyObserver();
    }
}
