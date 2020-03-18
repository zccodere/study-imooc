package com.myimooc.java.design.pattern.observer.push;

/**
 * 观察者接口，定义一个更新的接口给那些在目标对象发生改变的时候被通知的对象
 *
 * @author zc 2017-08-29
 */
public interface Observer {

    /**
     * 更新的接口
     *
     * @param weatherContent 传入的目标对象，方便获取相应的目标对象的状态
     */
    void update(String weatherContent);

}
