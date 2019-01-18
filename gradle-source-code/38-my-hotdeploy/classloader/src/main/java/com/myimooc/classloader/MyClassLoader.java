package com.myimooc.classloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

/**
 * @title 自定义Java类加载器
 * @describe 来实现Java类的热加载
 * @author zc
 * @version 1.0 2017-12-01
 */
public class MyClassLoader extends ClassLoader{
	
	/** 要加载的Java类的classpath路径 */
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
	 * @title 加载class文件中的内容
	 * @describe 加载class文件中的内容
	 * @author zc
	 * @version 1.0 2017-12-01
	 */
	private byte[] loadClassData(String name) {
		try{
			name = name.replace(".", "//");
			FileInputStream is = new FileInputStream(new File(this.classpath + name +".class"));
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			int b = 0;
			while((b = is.read()) != -1){
				baos.write(b);
			}
			is.close();
			return baos.toByteArray();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
