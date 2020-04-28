package com.myimooc.deploy.classloader;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * Manager工厂类；加载manager的工厂
 *
 * @author zc 2017-12-01
 */
public class ManagerFactory {

    /**
     * 记录热加载类的加载信息
     */
    private static final Map<String, LoadInfo> LOAD_TIME_MAP = new HashMap<>();

    /**
     * 要加载的类的classpath路径
     */
    private static final String CLASS_PATH = "D:/Study/ByGithub/study-imooc/38-boot-deploy/38-boot-deploy-classloader/target/classes/";
    /**
     * 实现热加载的类的全名称（包名+类名）
     */
    public static final String MY_MANAGER = "com.myimooc.deploy.classloader.MyManager";

    public static BaseManager getManager(String className) {
        File loadFile = new File(CLASS_PATH + className.replaceAll("/.", "/") + ".class");
        long lastModified = loadFile.lastModified();

        if (LOAD_TIME_MAP.get(className) == null) {
            // loadTimeMap不包含className为key的LoadInfo信息。
            // 证明这个类没有被加载，那么需要加载这个类到JVM中
            load(className, lastModified);

        } else if (LOAD_TIME_MAP.get(className).getLoadTime() != lastModified) {
            // 加载类的时间戳变化了，同样要重新加载
            load(className, lastModified);
        }

        return LOAD_TIME_MAP.get(className).getManager();
    }

    private static void load(String className, long lastModified) {
        MyClassLoader myClassLoader = new MyClassLoader(CLASS_PATH);
        Class<?> loadClass;
        try {
            loadClass = myClassLoader.findClass(className);
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException("类加载失败：" + ex.getMessage(), ex);
        }
        BaseManager manager = newInstance(loadClass);
        LoadInfo loadInfo = new LoadInfo(myClassLoader, lastModified);
        loadInfo.setManager(manager);
        LOAD_TIME_MAP.put(className, loadInfo);
    }

    /**
     * 创建实例对象；以反射的方式创建BaseManager子类对象
     */
    private static BaseManager newInstance(Class<?> loadClass) {
        try {
            return (BaseManager) loadClass.getConstructor(new Class[]{}).newInstance(new Object[]{});
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
                | NoSuchMethodException | SecurityException e) {
            e.printStackTrace();
        }
        return null;
    }
}
