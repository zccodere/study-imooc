package com.immoc.pattern.adapter;

public class NoteBook {

	private ThreePlugIf  plug;
	
	public NoteBook(ThreePlugIf plug){
		this.plug = plug;
	}
	
	//Ê¹ÓÃ²å×ù³äµç
	public void charge(){
		plug.powerWithThree();
	}
	
	public static void main(String[] args) {
		GBTwoPlug two =  new GBTwoPlug();
		ThreePlugIf three = new TwoPlugAdapter(two);
		NoteBook nb = new NoteBook(three);
		nb.charge();
		
		
		three = new TwoPlugAdapterExtends();
		nb = new NoteBook(three);
		nb.charge();

	}

}
