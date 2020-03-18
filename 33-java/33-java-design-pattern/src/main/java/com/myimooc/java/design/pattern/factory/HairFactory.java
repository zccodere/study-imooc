package com.myimooc.java.design.pattern.factory;

import com.myimooc.java.design.pattern.factory.hair.HairInterface;
import com.myimooc.java.design.pattern.factory.hair.LeftHair;
import com.myimooc.java.design.pattern.factory.hair.PropertiesReader;
import com.myimooc.java.design.pattern.factory.hair.RightHair;

import java.util.Map;

/**
 * 发型工厂
 *
 * @author zc 2017-08-27
 */
public class HairFactory {

    private static final String HAIR_LEFT = "left";
    private static final String HAIR_RIGHT = "right";

    /**
     * 根据类型来创建对象
     */
    public HairInterface getHair(String key) {
        if (HAIR_LEFT.equals(key)) {
            return new LeftHair();
        } else if (HAIR_RIGHT.equals(key)) {
            return new RightHair();
        }
        return null;
    }

    /**
     * 根据类的名称来生产对象
     */
    public HairInterface getHairByClass(String className) {
        try {
            return (HairInterface) Class.forName(className).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 根据类的名称来生产对象
     */
    public HairInterface getHairByClassKey(String key) {
        try {
            Map<String, String> map = new PropertiesReader().getProperties();
            return (HairInterface) Class.forName(map.get(key)).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
