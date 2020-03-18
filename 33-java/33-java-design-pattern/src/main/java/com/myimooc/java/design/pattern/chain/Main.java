package com.myimooc.java.design.pattern.chain;

import com.myimooc.java.design.pattern.chain.handler.PriceHandlerFactory;

import java.util.Random;

/**
 * 启动类
 *
 * @author zc 2020-03-18
 */
public class Main {

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
