package com.myimooc.guice.demo.aop;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @title Logged注解
 * @describe 用于标识需要记录日志的方法
 * @author zc
 * @version 1.0 2017-10-15
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Logged {
	
}
