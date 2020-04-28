package com.myimooc.java.design.pattern.chain.handler;

/**
 * 责任链模式； Ceo， 可以批准55%以内的折扣。折扣超出55%， 就拒绝申请
 *
 * @author zc 2017-08-30
 */
public class Ceo extends AbstractPriceHandler {

    private static final float DISCOUNT = 0.55f;

    @Override
    public void processDiscount(float discount) {
        if (discount <= DISCOUNT) {
            System.out.format("%s批准了折扣：%.2f%n", this.getClass().getName(), discount);
        } else {
            System.out.format("%s拒绝了折扣：%.2f%n", this.getClass().getName(), discount);
        }
    }
}
