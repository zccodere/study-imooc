package com.myimooc.java.design.pattern.factory;

import com.myimooc.java.design.pattern.factory.boy.Boy;
import com.myimooc.java.design.pattern.factory.boy.HnBoy;
import com.myimooc.java.design.pattern.factory.girl.Girl;
import com.myimooc.java.design.pattern.factory.girl.HnGirl;

/**
 * 新年系列加工厂
 *
 * @author zc 2017-08-27
 */
public class HnFactory implements PersonFactory {

    @Override
    public Boy getBoy() {
        return new HnBoy();
    }

    @Override
    public Girl getGirl() {
        return new HnGirl();
    }
}
