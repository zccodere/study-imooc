package com.myimooc.spring.aop.log.datalog;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 字段注解；该注解用于获取被标识字段的中文名
 *
 * @author zc 2017-09-13
 */
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface DataLog {

    /**
     * 中文字段名称
     *
     * @return 字段名称
     */
    String value() default "";
}
