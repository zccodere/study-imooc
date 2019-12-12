package com.myimooc.java.design.pattern.chain.handler;

/**
 * @author zc
 * @version 1.0 2017-08-30
 * @title 责任链模式
 * @describe 价格处理人，负责处理客户折扣申请
 */
public abstract class AbstractPriceHandler {

    protected AbstractPriceHandler successor;

    public void setSuccessor(AbstractPriceHandler successor) {
        this.successor = successor;
    }

    /**
     * 处理折扣申请
     *
     * @param discount 折扣
     */
    public abstract void processDiscount(float discount);

    /**
     * 创建PriceHandler的工厂方法
     */
    public static AbstractPriceHandler createPriceHandler() {
        // 创建对象
        AbstractPriceHandler sales = new Sales();
        AbstractPriceHandler man = new Manager();
        AbstractPriceHandler dir = new Director();
        AbstractPriceHandler vp = new VicePresident();
        AbstractPriceHandler ceo = new Ceo();
        // 指定直接后继
        sales.setSuccessor(man);
        man.setSuccessor(dir);
        dir.setSuccessor(vp);
        vp.setSuccessor(ceo);

        // 返回销售人员
        return sales;
    }

}
