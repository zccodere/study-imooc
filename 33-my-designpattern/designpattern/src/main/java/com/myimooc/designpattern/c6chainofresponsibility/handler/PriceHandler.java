package com.myimooc.designpattern.c6chainofresponsibility.handler;

/**
 * @title 责任链模式
 * @describe 价格处理人，负责处理客户折扣申请
 * @author zc
 * @version 1.0 2017-08-30
 */
public abstract class PriceHandler {
	
	protected PriceHandler successor;

	public void setSuccessor(PriceHandler successor) {
		this.successor = successor;
	}
	
	/**
	 * 处理折扣申请
	 */
	public abstract void processDiscount(float discount);
	
	/**
	 * 创建PriceHandler的工厂方法
	 */
	public static PriceHandler createPriceHandler() {
		// 创建对象
		PriceHandler sales = new Sales();
		PriceHandler man = new Manager();
		PriceHandler dir = new Director();
		PriceHandler vp = new VicePresident();
		PriceHandler ceo = new CEO();
		// 指定直接后继
		sales.setSuccessor(man);
		man.setSuccessor(dir);
		dir.setSuccessor(vp);
		vp.setSuccessor(ceo);
		
		// 返回销售人员
		return sales;
	}
	
}
