package com.myimooc.spring.simple.beanannotation.jsr;

import org.springframework.stereotype.Repository;

/**
 * <br>
 * 标题: 使用@Repository<br>
 * 描述: 使用@Repository<br>
 * 时间: 2017/01/18<br>
 *
 * @author zc
 */
@Repository
public class JsrDAO {
	
	public void save() {
		System.out.println("JsrDAO invoked.");
	}
	
}
