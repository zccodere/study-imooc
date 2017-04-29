package com.zs.spring.demo4;

import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * @author admin
 *
 *
 *@Transactional中的的属性
 *propagation	:事务的传播行为
 *isolation		:事务的隔离级别
 *readOnly		:只读
 *rollbackFor	:发生哪些异常回滚
 *noRollbackFor	:发生哪些异常不回滚
 *rollbackForClassName 根据异常类名回滚
 */
@Transactional
public class AccountServiceImpl implements AccountService {
	
	//注入转账的DAO
	private AccountDao accountDao;
	

	/**
	 * @param out	:转出账号
	 * @param in	:转入账号
	 * @param money	:转账金额
	 */
	@Override
	public void transfer( String out, String in, Double money) {
		accountDao.outMoney(out, money);
		//int i = 1/0;
		accountDao.inMoney(in, money);
		
	}

	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

}
