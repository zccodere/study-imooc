package com.myimooc.designpattern.c2factory;

import com.myimooc.designpattern.c2factory.boy.Boy;
import com.myimooc.designpattern.c2factory.boy.HnBoy;
import com.myimooc.designpattern.c2factory.girl.Girl;
import com.myimooc.designpattern.c2factory.girl.HnGril;

/**
 * @describe 新年系列加工厂
 * @author zc
 * @version 1.0 2017-08-27
 */
public class HnFactory implements PersonFactory {

	@Override
	public Boy getBoy() {
		return new HnBoy();
	}

	@Override
	public Girl getGirl() {
		return new HnGril();
	}
}
