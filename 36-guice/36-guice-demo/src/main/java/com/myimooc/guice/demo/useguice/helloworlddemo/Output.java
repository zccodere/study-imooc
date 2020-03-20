package com.myimooc.guice.demo.useguice.helloworlddemo;

import com.google.inject.BindingAnnotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Output注解
 *
 * @author zc 2017-10-15
 */
@Retention(RetentionPolicy.RUNTIME)
@BindingAnnotation
public @interface Output {

}
