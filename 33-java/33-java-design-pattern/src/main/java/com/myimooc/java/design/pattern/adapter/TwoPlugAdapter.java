package com.myimooc.java.design.pattern.adapter;

/**
 * @describe 二相转三相的插座适配器-聚合方式
 * 怎么实现的
 * 1.实现目标接口 ThreePlug
 * 2.聚合 GbTwoPlug 类到当前适配器类中为成员变量
 * 3.把“被适配者”作为一个对象聚合到适配器类中，以修改目标接口包装被适配者
 * @author zc
 * @version 1.0 2017-08-29
 */
public class TwoPlugAdapter implements ThreePlug {
	
	private GbTwoPlug plug;
	
	public TwoPlugAdapter(GbTwoPlug plug) {
		this.plug = plug;
	}

	@Override
	public void powerWithThree() {
		System.out.println("通过转换-聚合方式");
		plug.powerWithTwo();
	}
}
