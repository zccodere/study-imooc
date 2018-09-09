package com.imooc.dynamic;

import com.imooc.pattern.RealSubject;
import com.imooc.pattern.Subject;

import java.lang.reflect.Proxy;

/**
 * System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
 * Created by cat on 2017-02-27.
 */
public class Client {

    public static void main(String[] args){
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        Subject subject = (Subject) Proxy.newProxyInstance(Client.class.getClassLoader(),new Class[]{Subject.class},new JdkProxySubject(new RealSubject()));
        subject.hello();
    }
}
