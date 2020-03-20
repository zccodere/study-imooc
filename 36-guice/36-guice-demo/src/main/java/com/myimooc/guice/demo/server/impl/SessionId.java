package com.myimooc.guice.demo.server.impl;

import com.google.inject.BindingAnnotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * SessionId注解；用来绑定数据
 *
 * @author zc 2017-10-15
 */
@Retention(RetentionPolicy.RUNTIME)
@BindingAnnotation
public @interface SessionId {

}
