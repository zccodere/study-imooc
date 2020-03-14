 package com.imooc.pattern.template;

/*
 * �������࣬�ṩ���Ʊ���ľ���ʵ��
 */
public class Tea extends RefreshBeverage {

	@Override
	protected void brew() {
		System.out.println("��80�ȵ���ˮ���ݲ�Ҷ5����");
	}

	@Override
	protected void addCondiments() {
		System.out.println("��������");
	}

	@Override
	/*
	 * ����ͨ�����ǵ���ʽѡ����ع��Ӻ���
	 * @see com.imooc.pattern.templates.RefreshBeverage#isCustomerWantsCondiments()
	 */
	protected boolean isCustomerWantsCondiments(){
		return false;
	}
	
}
