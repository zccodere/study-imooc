package com.myimooc.spring.tx.demo1;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * 账户服务实现
 *
 * @author zc 2017-02-16
 */
public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao;

    private TransactionTemplate transactionTemplate;

    @Override
    public void transfer(final String out, final String in, final Double money) {
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                accountDao.outMoney(out, money);
                //int i = 1/0;
                accountDao.inMoney(in, money);
            }
        });
    }

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
        this.transactionTemplate = transactionTemplate;
    }

}
