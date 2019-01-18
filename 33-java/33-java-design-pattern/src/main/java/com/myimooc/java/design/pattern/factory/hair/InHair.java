package com.myimooc.java.design.pattern.factory.hair;

/**
 * @describe 中偏分发型
 * @author zc
 * @version 1.0 2017-08-27
 */
public class InHair implements HairInterface{

	@Override
	public void draw() {
		System.out.println("中偏分发型");
	}
}
