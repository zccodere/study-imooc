package com.myimooc.java.design.pattern.factory;


import com.myimooc.java.design.pattern.factory.boy.Boy;
import com.myimooc.java.design.pattern.factory.boy.McBoy;
import com.myimooc.java.design.pattern.factory.girl.Girl;
import com.myimooc.java.design.pattern.factory.girl.McGirl;

/**
 * 圣诞系列加工厂
 *
 * @author zc 2017-08-27
 */
public class McFactory implements PersonFactory {

    @Override
    public Boy getBoy() {
        return new McBoy();
    }

    @Override
    public Girl getGirl() {
        return new McGirl();
    }
}
