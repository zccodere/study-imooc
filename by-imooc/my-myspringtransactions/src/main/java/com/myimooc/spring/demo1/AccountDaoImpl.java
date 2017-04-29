package com.myimooc.spring.demo1;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao {

	/**
	 * @param out	:ת���˺�
	 * @param money	:ת�˽��
	 */
	@Override
	public void outMoney(String out, Double money) {
		String sql = "update account set money = money-? where name = ?";
		this.getJdbcTemplate().update(sql, money, out);
	}

	/**
	 * @param in	:ת���˺�
	 * @param money	:ת�˽��
	 */
	@Override
	public void inMoney(String in, Double money) {
		String sql = "update account set money = money+? where name = ?";
		this.getJdbcTemplate().update(sql,money,in);
	}

}
