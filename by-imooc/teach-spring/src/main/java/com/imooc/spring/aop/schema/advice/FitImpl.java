package com.imooc.spring.aop.schema.advice;

import com.imooc.aop.schema.advice.Fit;

public class FitImpl implements Fit {

	@Override
	public void filter() {
		System.out.println("FitImpl filter.");
	}

}
