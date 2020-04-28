package com.myimooc.guice.spring.config;

import com.google.inject.servlet.GuiceFilter;

import javax.servlet.annotation.WebFilter;

/**
 * 配置类；注册GuiceFilter
 *
 * @author zc 2017-10-15
 */
@WebFilter
public class SpringAwareGuiceFilter extends GuiceFilter {

}
