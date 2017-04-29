package com.myimooc.spring.demo1;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;


public class AccountServiceImpl implements AccountService {
	
	//ע��ת�˵�DAO
	private AccountDao accountDao;
	
	
	//ע����������ģ��
	private TransactionTemplate transactionTemplate;

	/**
	 * @param out	:ת���˺�
	 * @param in	:ת���˺�
	 * @param money	:ת�˽��
	 */
	@Override
	public void transfer(final String out, final String in, final Double money) {
		/*accountDao.outMoney(out, money);
		//int i = 1/0;
		accountDao.inMoney(in, money);*/
		
		
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
