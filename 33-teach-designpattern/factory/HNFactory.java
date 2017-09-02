package com.sunny.project;
/**
 * 新年系列加工厂
 * @author Administrator
 *
 */
public class HNFactory implements PersonFactory {

	@Override
	public Boy getBoy() {
		// TODO Auto-generated method stub
		return new HNBoy();
	}

	@Override
	public Girl getGirl() {
		// TODO Auto-generated method stub
		return new HNGirl();
	}

}
