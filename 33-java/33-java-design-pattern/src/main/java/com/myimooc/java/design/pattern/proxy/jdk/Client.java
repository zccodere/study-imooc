package com.myimooc.java.design.pattern.proxy.jdk;

import com.myimooc.java.design.pattern.proxy.car.Car;
import com.myimooc.java.design.pattern.proxy.car.MoveAble;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * JDK动态代理测试类
 *
 * @author zc 2017-08-28
 */
public class Client {

    public static void main(String[] args) {
        Car car = new Car();
        InvocationHandler h = new TimeHandler(car);
        Class<?> carClass = car.getClass();

        // 使用Proxy类newProxyInstance方法动态创建代理类；loader 类加载器；interfaces 实现接口；h InvocationHandler
        MoveAble m = (MoveAble) Proxy.newProxyInstance(carClass.getClassLoader(), carClass.getInterfaces(), h);

        m.move();
    }
}
