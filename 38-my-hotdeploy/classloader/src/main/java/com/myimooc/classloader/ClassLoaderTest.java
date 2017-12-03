package com.myimooc.classloader;

/**
 * @title 测试类
 * @describe 测试Java类的热加载
 * @author zc
 * @version 1.0 2017-12-01
 */
public class ClassLoaderTest {
	
	public static void main(String[] args) {
		new Thread(new MsgHandler()).start();
	}
}

