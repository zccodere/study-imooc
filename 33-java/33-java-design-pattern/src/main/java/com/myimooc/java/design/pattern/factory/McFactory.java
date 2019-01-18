package com.myimooc.java.design.pattern.factory;


import com.myimooc.java.design.pattern.factory.boy.Boy;
import com.myimooc.java.design.pattern.factory.boy.McBoy;
import com.myimooc.java.design.pattern.factory.girl.Girl;
import com.myimooc.java.design.pattern.factory.girl.McGril;

/**
 * @describe 圣诞系列加工厂
 * @author zc
 * @version 1.0 2017-08-27
 */
public class McFactory implements PersonFactory {

	@Override
	public Boy getBoy() {
		return new McBoy();
	}

	@Override
	public Girl getGirl() {
		return new McGril();
	}
}
