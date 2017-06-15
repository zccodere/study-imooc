package com.myimooc.spring.demo2;



public class AccountServiceImpl implements AccountService {
	
	//ע��ת�˵�DAO
	private AccountDao accountDao;
	

	/**
	 * @param out	:ת���˺�
	 * @param in	:ת���˺�
	 * @param money	:ת�˽��
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
