package com.myimooc.designpattern.c2factory;

import com.myimooc.designpattern.c2factory.boy.Boy;
import com.myimooc.designpattern.c2factory.girl.Girl;

/**
 * @describe 人物的实现接口
 * @author zc
 * @version 1.0 2017-08-27
 */
public interface PersonFactory {
	
	// 获取男孩接口
	Boy getBoy();
	
	// 获取女孩接口
	Girl getGirl();
}
