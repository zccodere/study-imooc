package com.myimooc.wxdevadvanced.domain.trans;

/**
 * 百度翻译API
 * @author ZhangCheng on 2017-08-12
 *
 */
public class Data {
	private String word_name;
	private Symbols[] symbols;
	public String getWord_name() {
		return word_name;
	}
	public void setWord_name(String word_name) {
		this.word_name = word_name;
	}
	public Symbols[] getSymbols() {
		return symbols;
	}
	public void setSymbols(Symbols[] symbols) {
		this.symbols = symbols;
	}
}
