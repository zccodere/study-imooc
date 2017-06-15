package com.myimooc.spring.mydemo1.dao.impl;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.myimooc.spring.mydemo1.dao.AccountDao;

/**
 * 转账案例DAO层实现类
 * 
 * @author zhangcheng
 * @version v1.0 2017-02-16
 *
 */
public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao {

    /*
     * @see com.myimooc.spring.dao.AccountDao#outMoney(java.lang.String,
     * java.lang.Double)
     */
    @Override
    public void outMoney(String out, Double money) {
        String sql = "update account set money = money - ? where name =?";
        this.getJdbcTemplate().update(sql, money,out);

    }

    /*
     * @see com.myimooc.spring.dao.AccountDao#inMoney(java.lang.String,
     * java.lang.Double)
     */
    @Override
    public void inMoney(String in, Double money) {
        String sql = "update account set money = money + ? where name =?";
        this.getJdbcTemplate().update(sql, money,in);
    }

}
