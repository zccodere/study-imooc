package com.myimooc.spring.simple.aop.schema.advisors;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 自定义注解；仅用作标记注解
 *
 * @author zc 2017-01-18
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Idempotent {

}
