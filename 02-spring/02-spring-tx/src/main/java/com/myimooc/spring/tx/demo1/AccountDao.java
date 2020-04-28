package com.myimooc.spring.tx.demo1;

/**
 * 账户DAO
 *
 * @author zc 2017-02-16
 */
public interface AccountDao {

    /**
     * 出账
     *
     * @param out   转出账户
     * @param money 金额
     */
    void outMoney(String out, Double money);

    /**
     * 入账
     *
     * @param in    转入账户
     * @param money 金额
     */
    void inMoney(String in, Double money);
}
