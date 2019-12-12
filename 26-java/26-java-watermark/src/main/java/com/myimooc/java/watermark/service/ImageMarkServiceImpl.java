package com.myimooc.java.watermark.service;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

/**
 * 图片水印服务类，添加图片水印
 * @author ZhangCheng on 2017-07-22
 *
 */
@SuppressWarnings("unused")
public class ImageMarkServiceImpl implements MarkService {

	@Override
	public String watermake(File imageFile, String imageFileName, String uploadPath, String realUploadPath) {
		
		String logoFileName = "logo_" + imageFileName;
		OutputStream os = null;
		
		// 图片地址
		String logoPath = realUploadPath + "/" + LOGO;
		
		try {
			Image image = ImageIO.read(imageFile);
			// 原图宽度
			int width = image.getWidth(null);
			// 原图高度
			int height = image.getHeight(null);
			
			// 创建图片缓存对象
			BufferedImage bufferedImage = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
			// 创建绘绘图工具对象
			Graphics2D g = bufferedImage.createGraphics();
			// 使用绘图工具将原图绘制到缓存图片对象
			g.drawImage(image, 0, 0, width,height,null);
			
			// 读取Logo图片
			File logo = new File(logoPath);
			Image imageLogo = ImageIO.read(logo);
			
			// 获取Logo图片的宽度和高度
			int markWidth = imageLogo.getWidth(null);
			int markHeight = imageLogo.getHeight(null);
			
			// 原图和Logo图片的高度和宽度之差
			int widthDiff = width - markWidth;
			int heightDiff = height - markHeight;
			
			int x = X;
			int y = Y;
			
			// 判断设置的值是否大于图片大小
			if(x > widthDiff){
				x = widthDiff;
			}
			if(y > heightDiff){
				y =heightDiff;
			}
			
			// 设置水印透明度
			g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, ALPHA));
			
			// 添加水印
			g.drawImage(imageLogo, x, y, null);
			
			g.dispose();
			
			os = new FileOutputStream(realUploadPath + "/" + logoFileName);
			JPEGImageEncoder en = JPEGCodec.createJPEGEncoder(os);
			en.encode(bufferedImage);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(os!=null){
				try {
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		return uploadPath + "/" + logoFileName;
		
	}

}
