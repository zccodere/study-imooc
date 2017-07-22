package com.myimooc.thumbnail.service;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * 缩略图服务类
 * 
 * @author ZhangCheng on 2017-07-19
 *
 */
@Service
public class ThumbnailAWTService {

	public static final int WIDTH = 100;
	public static final int HEIGHT = 100;

	@SuppressWarnings("static-access")
	public String thumbnail(MultipartFile file, String uploadPath, String realUploadPath) {

		OutputStream os = null;

		try {
			String des = realUploadPath + "/thum_" + file.getOriginalFilename();

			os = new FileOutputStream(des);

			Image image = ImageIO.read(file.getInputStream());
			int width = image.getWidth(null);// 原图狂宽度
			int height = image.getHeight(null);// 原图高度

			int rateWidth = width / WIDTH;// 宽度缩略比例
			int rateHeight = height / HEIGHT;// 高度缩略比

			// 宽度缩略比例大于高度缩略比例，使用宽度缩略比例
			int rate = rateWidth > rateHeight ? rateWidth : rateHeight;

			// 计算缩略图最终的宽度和高度
			int newWidth = width / rate;
			int newHeight = height / rate;

			BufferedImage bufferedImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_RGB);

			bufferedImage.getGraphics().drawImage(image.getScaledInstance(newWidth, newHeight, image.SCALE_SMOOTH), 0,
					0, null);

			String imageType = file.getContentType().substring(file.getContentType().indexOf("/") + 1);
			ImageIO.write(bufferedImage, imageType, os);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (os != null) {
				try {
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return uploadPath + "/thum_" + file.getOriginalFilename();
	}
}
