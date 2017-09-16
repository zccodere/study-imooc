package com.myimooc.springaopguide.domain;

/**
 * @title 产品领域模型
 * @describe 产品实体对象
 * @author zc
 * @version 1.0 2017-09-03
 */
public class Product {
	
	private Long id;
	
	private String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
