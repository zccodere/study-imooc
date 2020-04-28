package com.myimooc.java.design.pattern.chain.handler;

/**
 * 责任链模式；销售小组长， 可以批准15%以内的折扣
 *
 * @author zc 2017-08-30
 */
public class Lead extends AbstractPriceHandler {

    private static final float DISCOUNT = 0.15f;

    @Override
    public void processDiscount(float discount) {
        if (discount <= DISCOUNT) {
            System.out.format("%s批准了折扣：%.2f%n", this.getClass().getName(), discount);
        } else {
            successor.processDiscount(discount);
        }
    }
}
