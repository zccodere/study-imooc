package com.myimooc.java.design.pattern.factory;

import java.util.Map;

import com.myimooc.java.design.pattern.factory.hair.HairInterface;
import com.myimooc.java.design.pattern.factory.hair.LeftHair;
import com.myimooc.java.design.pattern.factory.hair.PropertiesReader;
import com.myimooc.java.design.pattern.factory.hair.RightHair;

/**
 * @author zc
 * @version 1.0 2017-08-27
 * @describe 发型工厂
 */
public class HairFactory {

    private static final String HAIR_LEFT = "left";
    private static final String HAIR_RIGHT = "right";

    /**
     * 根据类型来创建对象
     *
     * @param key
     * @return
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
     *
     * @param className
     * @return
     */
    public HairInterface getHairByClass(String className) {
        try {
            HairInterface hair = (HairInterface) Class.forName(className).newInstance();
            return hair;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 根据类的名称来生产对象
     *
     * @param key
     * @return
     */
    public HairInterface getHairByClassKey(String key) {
        try {
            Map<String, String> map = new PropertiesReader().getProperties();
            HairInterface hair = (HairInterface) Class.forName(map.get(key)).newInstance();
            return hair;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
