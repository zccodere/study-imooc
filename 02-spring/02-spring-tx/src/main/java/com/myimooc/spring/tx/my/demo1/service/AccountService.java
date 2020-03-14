package com.myimooc.spring.tx.my.demo1.service;

/**
 * 转账案例的业务功能接口
 *
 * @author zc 2017-02-16
 */
public interface AccountService {

    /**
     * 功能：转账功能。
     *
     * @param out   转出账号
     * @param in    转入账号
     * @param money 转账金额
     */
    void transfer(String out, String in, Double money);
}
