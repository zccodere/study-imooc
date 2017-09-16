package com.imooc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class ExecutionDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExecutionDemoApplication.class, args);
	}
}
