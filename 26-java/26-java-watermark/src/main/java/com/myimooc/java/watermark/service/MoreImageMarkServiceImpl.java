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

import org.springframework.stereotype.Service;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

/**
 * 图片水印服务类，添加多个图片水印
 * @author ZhangCheng on 2017-07-22
 *
 */
@Service
public class MoreImageMarkServiceImpl implements MarkService {

	@Override
	public String watermake(File imageFile, String imageFileName, String uploadPath, String realUploadPath) {
		
		String logoFileName = "logo_" + imageFileName;
		OutputStream os = null;
		
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
			
			// 图片地址
			String logoPath = realUploadPath + "/" + LOGO;
			
			// 读取Logo图片
			File logo = new File(logoPath);
			Image imageLogo = ImageIO.read(logo);
			
			// Logo图片的宽度和高度
			int markWidth = imageLogo.getWidth(null);
			int markHeight = imageLogo.getHeight(null);
			
			// 设置水印透明度
			g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, ALPHA));
			
			// 旋转图片
			g.rotate(Math.toRadians(30), bufferedImage.getWidth()/2, bufferedImage.getHeight()/2);
			
			int x = -width / 2;
			int y = -height / 2;

			// 水印之间的间隔
			int xmove = 200;
			// 水印之间的间隔
			int ymove = 200;
			
			// 循环添加
			double count = 1.5;
			while (x < width * count){
				y = -height / 2;
				while(y < height * count){
					// 添加水印
					g.drawImage(imageLogo, x, y, null);
					y += markHeight + ymove;
				}
				x += markWidth + xmove;
			}
			
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
