package com.imooc;
/*
 * 懒汉模式
 * 区别：饿汉模式的特点是加载类时比较慢，但运行时获取对象的速度比较快，线程安全
 *      懒汉模式的特点是加载类时比较快，但运行时获取对象的速度比较慢，线程不安全
 */
public class Singleton2 {
	//1.将构造方式私有化，不允许外边直接创建对象
	private Singleton2(){
	}
	
	//2.声明类的唯一实例，使用private static修饰
	private static Singleton2 instance;
	
	//3.提供一个用于获取实例的方法，使用public static修饰
	public static Singleton2 getInstance(){
		if(instance==null){
			instance=new Singleton2();
		}
		return instance;
	}
}
