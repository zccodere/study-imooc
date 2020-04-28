package com.myimooc.spring.simple.beanannotation.jsr;

import org.springframework.stereotype.Repository;

/**
 * 使用@Repository
 *
 * @author zc 2017-01-18
 */
@Repository
public class JsrDao {

    public void save() {
        System.out.println("JsrDao invoked.");
    }

}
