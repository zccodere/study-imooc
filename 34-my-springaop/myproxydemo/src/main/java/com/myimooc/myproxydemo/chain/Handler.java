package com.myimooc.myproxydemo.chain;

/**
 * @title 责任链模式
 * @describe 抽象接口
 * @author zc
 * @version 1.0 2017-09-13
 */
public abstract class Handler {
	
	// 后继Handler，是否有类进行处理
	private Handler sucessor;
	
	// 对外暴露
	public void execute(){
		handleProcess();
		if(sucessor != null){
			sucessor.execute();
		}
	}
	
	// 由子类实现
	protected abstract void handleProcess();
	
	public Handler getSucessor() {
		return sucessor;
	}

	public void setSucessor(Handler sucessor) {
		this.sucessor = sucessor;
	}
	
}
