package com.myimooc.spring.simple.aop.schema.advisors;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * <br>
 * 标题: 自定义注解<br>
 * 描述: 自定义注解<br>
 * 时间: 2017/01/18<br>
 *
 * @author zc
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Idempotent {
    // marker annotation
}
