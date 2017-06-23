package com.myimooc.qrcode;

import java.awt.image.BufferedImage;

import jp.sourceforge.qrcode.data.QRCodeImage;

/**
 * 读取 二维码 时，需实现 QRCodeImage 接口
 * 
 * @author ZhangCheng on 2017-06-23
 */
public class MyQRCodeImage implements QRCodeImage{
	
	BufferedImage bufferedImage;
	
	public MyQRCodeImage(BufferedImage bufferedImage){
		this.bufferedImage = bufferedImage;
	}
	
	@Override
	public int getHeight() {
		return bufferedImage.getHeight();
	}

	@Override
	public int getPixel(int arg0, int arg1) {
		return bufferedImage.getRGB(arg0, arg1);
	}

	@Override
	public int getWidth() {
		return bufferedImage.getWidth();
	}
	
	
	
}
