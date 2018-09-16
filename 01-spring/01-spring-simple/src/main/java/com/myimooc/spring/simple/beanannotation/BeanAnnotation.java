package com.myimooc.spring.simple.beanannotation;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * <br>
 * 标题: 使用@Component<br>
 * 描述: 使用@Component<br>
 * 时间: 2017/01/18<br>
 *
 * @author zc
 */
@Scope
@Component
public class BeanAnnotation {

    public void say(String arg) {
        System.out.println("BeanAnnotation : " + arg);
    }

    public void myHashCode() {
        System.out.println("BeanAnnotation : " + this.hashCode());
    }

}
