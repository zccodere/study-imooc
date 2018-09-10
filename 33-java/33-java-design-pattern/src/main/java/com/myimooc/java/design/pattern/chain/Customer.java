package com.myimooc.java.design.pattern.chain;

import java.util.Random;

import com.myimooc.java.design.pattern.chain.handler.AbstractPriceHandler;
import com.myimooc.java.design.pattern.chain.handler.PriceHandlerFactory;

/**
 * @author zc
 * @version 1.0 2017-08-30
 * @title 责任链模式
 * @describe 客户，请求折扣
 */
public class Customer {

    private AbstractPriceHandler priceHandler;

    public void setPriceHandler(AbstractPriceHandler priceHandler) {
        this.priceHandler = priceHandler;
    }

    public void requestDiscount(float discount) {
        priceHandler.processDiscount(discount);
    }

    public static void main(String[] args) {
        Customer customer = new Customer();
        customer.setPriceHandler(PriceHandlerFactory.createPriceHandler());

        Random rand = new Random();

        int count = 100;
        for (int i = 1; i <= count; i++) {
            System.out.print(i + ":");
            customer.requestDiscount(rand.nextFloat());
        }
    }
}
