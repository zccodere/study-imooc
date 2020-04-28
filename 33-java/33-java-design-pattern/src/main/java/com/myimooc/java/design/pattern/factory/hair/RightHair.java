package com.myimooc.java.design.pattern.factory.hair;

/**
 * 右偏分发型
 *
 * @author zc 2017-08-27
 */
public class RightHair implements HairInterface {

    /**
     * 画一个右偏分发型
     */
    @Override
    public void draw() {
        System.out.println("右偏分发型");
    }

}
