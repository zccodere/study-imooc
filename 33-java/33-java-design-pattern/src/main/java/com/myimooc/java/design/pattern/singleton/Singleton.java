package com.myimooc.java.design.pattern.singleton;

/**
 * 单例模式Singleton-饿汉模式：当类被加载时，就创建实例
 * <p>
 * 应用场合：有些对象只需要一个就足够了，古古代皇帝； 作用：保证整个应用程序中某个实例有且只有一个； 类型：饿汉模式、懒汉模式。
 * </p>
 *
 * @author zc 2017-08-27
 */
public class Singleton {

    /**
     * 1.将构造方法私有化，不允许外部直接创建对象
     */
    private Singleton() {
    }

    /**
     * 2.创建类的唯一实例，使用private static
     */
    private static Singleton instance = new Singleton();

    /**
     * 3.提供一个用于获取实例的方法，使用public static
     *
     * @return 实例
     */
    public static Singleton getInstance() {
        return instance;
    }
}
