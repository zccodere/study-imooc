package com.myimooc.java.design.pattern.chain.handler;

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
	public static AbstractPriceHandler createPriceHandler() {
		
		AbstractPriceHandler sales = new Sales();
		AbstractPriceHandler lead = new Lead();
		AbstractPriceHandler man = new Manager();
		AbstractPriceHandler dir = new Director();
		AbstractPriceHandler vp = new VicePresident();
		AbstractPriceHandler ceo = new Ceo();
		
		sales.setSuccessor(lead);
		lead.setSuccessor(man);
		man.setSuccessor(dir);
		dir.setSuccessor(vp);
		vp.setSuccessor(ceo);
		
		return sales;
	}

}
