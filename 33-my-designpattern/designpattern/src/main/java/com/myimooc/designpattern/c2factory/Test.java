package com.myimooc.designpattern.c2factory;

import com.myimooc.designpattern.c2factory.boy.Boy;
import com.myimooc.designpattern.c2factory.girl.Girl;
import com.myimooc.designpattern.c2factory.hair.HairInterface;

/**
 * @describe 模拟客户端实现
 * @author zc
 * @version 1.0 2017-08-27
 */
public class Test {
	
	public static void main(String[] args) {
		
//		HairInterface left = new LeftHair();
//		left.draw();
//		
//		HairInterface right = new RightHair();
//		right.draw();
		
		
		HairFactory factory = new HairFactory();
//		HairInterface left = factory.getHair("left");
//		left.draw();
		
		
		HairInterface left = factory.getHairByClass("com.myimooc.designpattern.c2factory.LeftHair");
		left.draw();
		
//		HairInterface hair = factory.getHairByClassKey("in");
//		hair.draw();
		
		testPerson();
	}
	
	public static void testPerson(){
		PersonFactory factory = new McFactory();
		Girl girl = factory.getGirl();
		girl.drawWomen();
		
		factory = new HnFactory();
		Boy boy = factory.getBoy();
		boy.drawMan();
		
	}
}
