package com.myimooc.spring.tx.mydemo1.dao.impl;

import com.myimooc.spring.tx.mydemo1.dao.AccountDao;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

/**
 * 转账案例DAO层实现类
 * 
 * @author zc
 * @version v1.0 2017-02-16
 *
 */
public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao {

    @Override
    public void outMoney(String out, Double money) {
        String sql = "update account set money = money - ? where name =?";
        this.getJdbcTemplate().update(sql, money,out);

    }

    @Override
    public void inMoney(String in, Double money) {
        String sql = "update account set money = money + ? where name =?";
        this.getJdbcTemplate().update(sql, money,in);
    }

}
