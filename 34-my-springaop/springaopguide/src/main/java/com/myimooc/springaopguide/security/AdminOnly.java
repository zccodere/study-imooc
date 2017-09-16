package com.myimooc.springaopguide.security;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @title 管理员权限注解
 * @describe 被该注解声明的方法需要管理员权限
 * @author zc
 * @version 1.0 2017-09-03
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface AdminOnly {

}
