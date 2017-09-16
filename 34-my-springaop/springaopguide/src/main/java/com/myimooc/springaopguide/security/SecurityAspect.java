package com.myimooc.springaopguide.security;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.myimooc.springaopguide.service.AuthService;

/**
 * @title 权限校验切面类
 * @describe 
 * @author zc
 * @version 1.0 2017-09-03
 */
// 声明为一个切面
@Aspect
@Component
public class SecurityAspect {
	
	@Autowired
	private AuthService authService;
	
	// 使用要拦截标注有AdminOnly的注解进行操作
	@Pointcut("@annotation(AdminOnly)")
	public void adminOnly(){
		
	}
	
	@Before("adminOnly()")
	public void check(){
		authService.checkAccess();
	}
	
}
