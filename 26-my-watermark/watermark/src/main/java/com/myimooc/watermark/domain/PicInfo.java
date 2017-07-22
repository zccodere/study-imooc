package com.myimooc.watermark.domain;

/**
 * 图片信息模型类
 * @author ZhangCheng on 2017-07-21
 *
 */
public class PicInfo {
	
	/** 原图访问路径 */
	private String imageURL;
	/** 添加水印后的访问路径 */
	private String logoImageURL;
	
	@Override
	public String toString() {
		return "PicInfo [imageURL=" + imageURL + ", logoImageURL=" + logoImageURL + "]";
	}
	public String getImageURL() {
		return imageURL;
	}
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
	public String getLogoImageURL() {
		return logoImageURL;
	}
	public void setLogoImageURL(String logoImageURL) {
		this.logoImageURL = logoImageURL;
	}
	
	
}
