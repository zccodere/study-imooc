package com.myimooc.spring.demo4;

import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * @author admin
 *
 *
 *@Transactional�еĵ�����
 *propagation	:����Ĵ�����Ϊ
 *isolation		:����ĸ��뼶��
 *readOnly		:ֻ��
 *rollbackFor	:������Щ�쳣�ع�
 *noRollbackFor	:������Щ�쳣���ع�
 *rollbackForClassName �����쳣�����ع�
 */
@Transactional
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
