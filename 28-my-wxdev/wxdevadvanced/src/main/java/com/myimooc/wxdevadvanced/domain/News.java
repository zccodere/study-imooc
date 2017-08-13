package com.myimooc.wxdevadvanced.domain;

/**
 * 消息回复
 * @author ZhangCheng on 2017-08-12
 *
 */
public class News {
	
	private String Title;
	private String Description;
	private String PicUrl;
	private String Url;
	
	@Override
	public String toString() {
		return "News [Title=" + Title + ", Description=" + Description + ", PicUrl=" + PicUrl + ", Url=" + Url + "]";
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getPicUrl() {
		return PicUrl;
	}
	public void setPicUrl(String picUrl) {
		PicUrl = picUrl;
	}
	public String getUrl() {
		return Url;
	}
	public void setUrl(String url) {
		Url = url;
	}
	
	
}
