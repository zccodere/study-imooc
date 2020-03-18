package com.myimooc.java.design.pattern.factory.hair;

/**
 * 左偏分发型
 *
 * @author zc 2017-08-27
 */
public class LeftHair implements HairInterface {

    /**
     * 画一个左偏分发型
     */
    @Override
    public void draw() {
        System.out.println("左偏分发型");
    }
}
