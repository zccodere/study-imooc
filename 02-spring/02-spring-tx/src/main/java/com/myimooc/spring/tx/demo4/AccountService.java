package com.myimooc.spring.tx.demo4;

/**
 * 转账服务
 *
 * @author zc 2017-02-16
 */
public interface AccountService {

    /**
     * 转账
     *
     * @param out   转出账户
     * @param in    转入账户
     * @param money 金额
     */
    void transfer(String out, String in, Double money);
}
