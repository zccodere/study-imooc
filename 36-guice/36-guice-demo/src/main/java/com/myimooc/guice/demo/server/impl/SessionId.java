package com.myimooc.guice.demo.server.impl;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import com.google.inject.BindingAnnotation;

/**
 * @title SessionId注解
 * @describe 用来绑定数据
 * @author zc
 * @version 1.0 2017-10-15
 */
@Retention(RetentionPolicy.RUNTIME)
@BindingAnnotation
public @interface SessionId {

}
