package com.myimooc.spring.tx.demo3;

/**
 * 账户DAO
 *
 * @author zc 2017-02-16
 */
public interface AccountDao {

    /**
     * 转出
     *
     * @param out   转出账户
     * @param money 金额
     */
    void outMoney(String out, Double money);

    /**
     * 转入
     *
     * @param in    转入账户
     * @param money 金额
     */
    void inMoney(String in, Double money);
}
