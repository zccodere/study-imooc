package com.myimooc.designpattern.c6chainofresponsibility.handler;

/**
 * @title 责任链模式
 * @describe 销售小组长， 可以批准15%以内的折扣
 * @author zc
 * @version 1.0 2017-08-30
 */
public class Lead extends PriceHandler {

	@Override
	public void processDiscount(float discount) {
		if(discount<=0.15){
			System.out.format("%s批准了折扣：%.2f%n",this.getClass().getName(),discount);
		}else{
			successor.processDiscount(discount);
		}
	}
}
