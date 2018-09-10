package com.myimooc.java.design.pattern.factory;

import com.myimooc.java.design.pattern.factory.boy.Boy;
import com.myimooc.java.design.pattern.factory.girl.Girl;

/**
 * @author zc
 * @version 1.0 2017-08-27
 * @describe 人物的实现接口
 */
public interface PersonFactory {

    /**
     * 获取男孩接口
     *
     * @return 男孩
     */
    Boy getBoy();

    /**
     * 获取女孩接口
     *
     * @return 女孩
     */
    Girl getGirl();
}
