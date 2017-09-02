package com.myimooc.designpattern.c6chainofresponsibility.handler;

/**
 * @title 责任链模式
 * @describe 创建PriceHandler的工厂类
 * @author zc
 * @version 1.0 2017-08-30
 */
public class PriceHandlerFactory {

	/**
	 * 创建PriceHandler的工厂方法，简单工厂方法或静态工厂方法
	 */
	public static PriceHandler createPriceHandler() {
		
		PriceHandler sales = new Sales();
		PriceHandler lead = new Lead();
		PriceHandler man = new Manager();
		PriceHandler dir = new Director();
		PriceHandler vp = new VicePresident();
		PriceHandler ceo = new CEO();
		
		sales.setSuccessor(lead);
		lead.setSuccessor(man);
		man.setSuccessor(dir);
		dir.setSuccessor(vp);
		vp.setSuccessor(ceo);
		
		return sales;
	}

}
