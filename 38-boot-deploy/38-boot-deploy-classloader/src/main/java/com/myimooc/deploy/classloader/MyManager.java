package com.myimooc.deploy.classloader;

/**
 * @title 接口实现类
 * @describe BaseManager的子类，此类需要实现Java类的热加载功能
 * @author zc
 * @version 1.0 2017-12-01
 */
public class MyManager implements BaseManager {

	@Override
	public void logic() {
		System.out.println("学习如何实现Java类的热加载案例");
	}
}
