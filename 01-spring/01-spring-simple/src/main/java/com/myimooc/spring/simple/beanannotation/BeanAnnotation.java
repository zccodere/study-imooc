package com.myimooc.spring.simple.beanannotation;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * 使用@Component
 *
 * @author zc 2017-01-18
 */
@Scope
@Component
public class BeanAnnotation {

    public void say(String arg) {
        System.out.println("BeanAnnotation : " + arg);
    }

    void myHashCode() {
        System.out.println("BeanAnnotation : " + this.hashCode());
    }

}
