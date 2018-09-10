package com.myimooc.guice.spring.config;

import javax.servlet.annotation.WebFilter;

import com.google.inject.servlet.GuiceFilter;

/**
 * @title 配置类
 * @describe 注册GuiceFilter
 * @author zc
 * @version 1.0 2017-10-15
 */
@WebFilter
public class SpringAwareGuiceFilter extends GuiceFilter {

}
