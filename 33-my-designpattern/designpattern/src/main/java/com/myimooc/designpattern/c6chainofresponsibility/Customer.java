package com.myimooc.designpattern.c6chainofresponsibility;

import java.util.Random;

import com.myimooc.designpattern.c6chainofresponsibility.handler.PriceHandler;
import com.myimooc.designpattern.c6chainofresponsibility.handler.PriceHandlerFactory;

/**
 * @title 责任链模式
 * @describe 客户，请求折扣
 * @author zc
 * @version 1.0 2017-08-30
 */
public class Customer {
	
	private PriceHandler priceHandler;
	
	public void setPriceHandler(PriceHandler priceHandler) {
		this.priceHandler = priceHandler;
	}

	public void requestDiscount(float discount){
		priceHandler.processDiscount(discount);
	}
	
	public static void main(String[] args){
		Customer customer = new Customer();
		customer.setPriceHandler(PriceHandlerFactory.createPriceHandler());
		
		Random rand = new Random();
		
		for(int i=1;i<=100;i++){
			System.out.print(i+":");
			customer.requestDiscount(rand.nextFloat());
		}
	}
}
