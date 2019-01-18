package com.imooc.cglib;

import com.imooc.pattern.RealSubject;
import com.imooc.pattern.Subject;
import net.sf.cglib.proxy.Enhancer;

/**
 * Created by cat on 2017-02-27.
 */
public class Client {

    public static void main(String[] args){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(RealSubject.class);
        enhancer.setCallback(new DemoMethodInterceptor());
        Subject subject = (Subject) enhancer.create();
        subject.hello();
    }
}
