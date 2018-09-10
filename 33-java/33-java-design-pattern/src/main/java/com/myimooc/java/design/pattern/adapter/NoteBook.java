package com.myimooc.java.design.pattern.adapter;

/**
 * @describe 笔记本电脑
 * @author zc
 * @version 1.0 2017-08-29
 */
public class NoteBook {
	
	/**
	 * 期望使用三相插座进行充电
	 */
	private ThreePlug plug;

	public NoteBook(ThreePlug plug) {
		this.plug = plug;
	}
	
	/**
	 * 使用插座进行充电
	 */
	public void charge(){
		plug.powerWithThree();
	}
	
	public static void main(String[] args) {
		GbTwoPlug two = new GbTwoPlug();
		// 使用二相转三相的适配器
		ThreePlug three = new TwoPlugAdapter(two);
		// 使用三相插座进行充电
		NoteBook nb = new NoteBook(three);
		nb.charge();
		
		three = new TwoPlugAdapterExtends();
		nb= new NoteBook(three);
		nb.charge();
	}
}
