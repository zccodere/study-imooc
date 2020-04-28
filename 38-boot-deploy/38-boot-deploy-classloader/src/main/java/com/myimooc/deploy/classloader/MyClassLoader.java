package com.myimooc.deploy.classloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

/**
 * 自定义Java类加载器；来实现Java类的热加载
 *
 * @author zc 2017-12-01
 */
public class MyClassLoader extends ClassLoader {

    /**
     * 要加载的Java类的classpath路径
     */
    private String classpath;

    public MyClassLoader(String classpath) {
        super(ClassLoader.getSystemClassLoader());
        this.classpath = classpath;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] data = this.loadClassData(name);
        return this.defineClass(name, data, 0, data.length);
    }

    /**
     * 加载class文件中的内容
     */
    private byte[] loadClassData(String name) throws ClassNotFoundException {
        try {
            name = name.replace(".", "//");
            FileInputStream is = new FileInputStream(new File(this.classpath + name + ".class"));
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            int b;
            while ((b = is.read()) != -1) {
                outputStream.write(b);
            }
            is.close();
            return outputStream.toByteArray();
        } catch (Exception ex) {
            throw new ClassNotFoundException("未找到指定类[" + name + "]：" + ex.getMessage(), ex);
        }
    }
}
