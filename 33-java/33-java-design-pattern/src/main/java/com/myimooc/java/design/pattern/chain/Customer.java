package com.myimooc.java.design.pattern.chain;

import com.myimooc.java.design.pattern.chain.handler.AbstractPriceHandler;

/**
 * 责任链模式；客户，请求折扣
 *
 * @author zc 2017-08-30
 */
public class Customer {

    private AbstractPriceHandler priceHandler;

    public void setPriceHandler(AbstractPriceHandler priceHandler) {
        this.priceHandler = priceHandler;
    }

    public void requestDiscount(float discount) {
        priceHandler.processDiscount(discount);
    }
}
