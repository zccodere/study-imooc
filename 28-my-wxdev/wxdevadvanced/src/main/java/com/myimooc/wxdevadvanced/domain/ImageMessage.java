package com.myimooc.wxdevadvanced.domain;

/**
 * 图片消息
 * @author ZhangCheng on 2017-08-12
 *
 */
public class ImageMessage extends BaseMessage{
	private Image Image;

	public Image getImage() {
		return Image;
	}

	public void setImage(Image image) {
		Image = image;
	}
}
