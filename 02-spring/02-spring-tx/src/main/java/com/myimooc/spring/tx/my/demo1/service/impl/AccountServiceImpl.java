package com.myimooc.spring.tx.my.demo1.service.impl;

import com.myimooc.spring.tx.my.demo1.dao.AccountDao;
import com.myimooc.spring.tx.my.demo1.service.AccountService;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * 转账案例的业务功能接口实现类
 *
 * @author zc 2017-02-16
 */
public class AccountServiceImpl implements AccountService {

    /**
     * 转账案例DAO接口
     */
    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    private TransactionTemplate transactionTemplate;

    public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
        this.transactionTemplate = transactionTemplate;
    }

    /**
     * 功能：转账功能。
     *
     * @param out   转出账号
     * @param in    转入账号
     * @param money 转账金额
     */
    @Override
    public void transfer(final String out, final String in, final Double money) {
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                accountDao.outMoney(out, money);
                accountDao.inMoney(in, money);
            }
        });
    }
}
