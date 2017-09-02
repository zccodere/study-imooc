package com.sunny.project;
/**
 * 人物的实现接口
 * @author Administrator
 *
 */
public interface PersonFactory {

	//男孩接口
	public Boy getBoy();
	//女孩接口
	public Girl getGirl();
	
}
