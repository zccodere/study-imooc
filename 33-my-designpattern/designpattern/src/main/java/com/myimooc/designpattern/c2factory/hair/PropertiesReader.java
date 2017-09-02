package com.myimooc.designpattern.c2factory.hair;

import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @describe properties文件读取类
 * @author zc
 * @version 1.0 2017-08-27
 */
public class PropertiesReader {
	
	public Map<String,String> getProperties(){
		Properties props = new Properties();
		Map<String,String> map = new HashMap<String,String>();
		try{
			InputStream in = getClass().getResourceAsStream("type.properties");
			props.load(in);
			@SuppressWarnings("unchecked")
			Enumeration<String> en = (Enumeration<String>) props.propertyNames();
			while (en.hasMoreElements()) {
				String key = en.nextElement();
				String property = props.getProperty(key);
				map.put(key, property);
			}
			in.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
}
