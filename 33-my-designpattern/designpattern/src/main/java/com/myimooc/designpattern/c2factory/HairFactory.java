package com.myimooc.designpattern.c2factory;

import java.util.Map;

import com.myimooc.designpattern.c2factory.hair.HairInterface;
import com.myimooc.designpattern.c2factory.hair.LeftHair;
import com.myimooc.designpattern.c2factory.hair.PropertiesReader;
import com.myimooc.designpattern.c2factory.hair.RightHair;

/**
 * @describe 发型工厂
 * @author zc
 * @version 1.0 2017-08-27
 */
public class HairFactory {
	
	/**
	 * 根据类型来创建对象
	 * @param key
	 * @return
	 */
	public HairInterface getHair(String key){
		if("left".equals(key)){
			return new LeftHair();
		}
		else if("right".equals(key)){
			return new RightHair();
		}
		return null;
	}
	
	/**
	 * 根据类的名称来生产对象
	 * @param className
	 * @return
	 */
	public HairInterface getHairByClass(String className){
		try {
			HairInterface hair = (HairInterface) Class.forName(className).newInstance();
			return hair;
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 根据类的名称来生产对象
	 * @param className
	 * @return
	 */
	public HairInterface getHairByClassKey(String key){
		try {
			Map<String,String> map = new PropertiesReader().getProperties();
			HairInterface hair = (HairInterface) Class.forName(map.get(key)).newInstance();
			return hair;
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
