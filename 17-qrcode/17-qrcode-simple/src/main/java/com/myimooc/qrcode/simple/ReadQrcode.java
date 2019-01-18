//package com.myimooc.qrcode.simple;
//
//import java.awt.image.BufferedImage;
//import java.io.File;
//import javax.imageio.ImageIO;
//
//import jp.sourceforge.qrcode.QRCodeDecoder;
//
///**
// * 读取 二维码 通过 Qrcode
// *
// * @author ZhangCheng on 2017-06-23
// */
//public class ReadQrcode {
//
//	public static void main(String[] args) throws Exception {
//
//		File file = new File("D:/qrcode.png");
//
//		BufferedImage bufferedImage = ImageIO.read(file);
//
//		QRCodeDecoder codeDecoder = new QRCodeDecoder();
//
//		String result = new String(codeDecoder.decode(new MyQrcodeImage(bufferedImage)),"gb2312");
//
//		System.out.println(result);
//	}
//
//}
