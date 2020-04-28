package com.myimooc.java.design.pattern.factory;

import com.myimooc.java.design.pattern.factory.boy.Boy;
import com.myimooc.java.design.pattern.factory.girl.Girl;
import com.myimooc.java.design.pattern.factory.hair.HairInterface;
import com.myimooc.java.design.pattern.factory.hair.LeftHair;
import com.myimooc.java.design.pattern.factory.hair.RightHair;

/**
 * 模拟客户端实现
 *
 * @author zc 2017-08-27
 */
public class Main {

    public static void main(String[] args) {

        HairInterface left0 = new LeftHair();
        left0.draw();

        HairInterface right = new RightHair();
        right.draw();


        HairFactory factory = new HairFactory();
        HairInterface left1 = factory.getHair("left");
        left1.draw();

        HairInterface left = factory.getHairByClass("com.myimooc.java.design.pattern.factory.hair.LeftHair");
        left.draw();

        HairInterface hair = factory.getHairByClassKey("in");
        hair.draw();

        testPerson();
    }

    public static void testPerson() {
        PersonFactory factory = new McFactory();
        Girl girl = factory.getGirl();
        girl.drawWomen();

        factory = new HnFactory();
        Boy boy = factory.getBoy();
        boy.drawMan();
    }
}
