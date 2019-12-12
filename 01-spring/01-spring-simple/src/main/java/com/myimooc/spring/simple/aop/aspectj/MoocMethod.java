package com.myimooc.spring.simple.aop.aspectj;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <br>
 * 标题: Mooc方法<br>
 * 描述: Mooc方法<br>
 * 时间: 2017/01/18<br>
 *
 * @author zc
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface MoocMethod {
	
	String value();

}
