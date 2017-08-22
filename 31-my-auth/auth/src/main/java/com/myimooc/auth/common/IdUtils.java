package com.myimooc.auth.common;

import java.text.SimpleDateFormat;
import java.util.Date;

public class IdUtils {
	
	public static Long getDateTimeStr(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		int a = (int)(Math.random()*(9999-1000+1))+1000;
		String result =  String.valueOf(sdf.format(new Date())) + String.valueOf(a);
		return Long.valueOf(result);
	}
	
}
