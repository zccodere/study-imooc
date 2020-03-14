package com.myimooc.spring.tx.demo3;

/**
 * 转账服务实现
 *
 * @author zc  2017-02-16
 */
public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao;

    @Override
    public void transfer(String out, String in, Double money) {
        accountDao.outMoney(out, money);
        //int i = 1/0;
        accountDao.inMoney(in, money);

    }

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

}
