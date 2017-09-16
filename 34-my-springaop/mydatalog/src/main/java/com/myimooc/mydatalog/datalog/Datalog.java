package com.myimooc.mydatalog.datalog;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @title 字段注解
 * @describe 该注解用于获取被标识字段的中文名
 * @author zc
 * @version 1.0 2017-09-13
 */
@Target({ ElementType.FIELD, ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface Datalog {

    // 中文字段名
    String value() default "";
}
