package com.myimooc.guice.spring.service;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import com.google.inject.BindingAnnotation;

/**
 * @title Output注解
 * @describe 
 * @author zc
 * @version 1.0 2017-10-15
 */
@Retention(RetentionPolicy.RUNTIME)
@BindingAnnotation
public @interface Output {

}
