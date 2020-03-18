package com.myimooc.java.design.pattern.chain.handler;

/**
 * 责任链模式；价格处理人，负责处理客户折扣申请
 *
 * @author zc 2017-08-30
 */
public abstract class AbstractPriceHandler {

    protected AbstractPriceHandler successor;

    /**
     * 设置下一个价格处理人
     *
     * @param successor 价格处理人
     */
    public void setSuccessor(AbstractPriceHandler successor) {
        this.successor = successor;
    }

    /**
     * 处理折扣申请
     *
     * @param discount 折扣
     */
    public abstract void processDiscount(float discount);
}
