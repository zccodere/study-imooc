package com.myimooc.java.design.pattern.adapter;

/**
 * 二相转三相的插座适配器-继承方式
 *
 * @author zc 2017-08-29
 */
public class TwoPlugAdapterExtends extends GbTwoPlug implements ThreePlug {

    @Override
    public void powerWithThree() {
        System.out.println("通过转换-继承方式");
        this.powerWithTwo();
    }
}
