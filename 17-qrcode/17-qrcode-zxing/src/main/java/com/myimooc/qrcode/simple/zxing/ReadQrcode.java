package com.myimooc.qrcode.simple.zxing;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

/**
 * 读取二维码
 *
 * @author zc 2017-06-23
 */
public class ReadQrcode {

    public static void main(String[] args) {
        MultiFormatReader formatReader = new MultiFormatReader();

        // 定义二维码文件路径
        File file = new File("D:/img.png");
        // 读取图片文件识别为一个图片流
        BufferedImage image;
        try {
            image = ImageIO.read(file);

            BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(image)));
            // 解析二维码；可以不用传入参数
            Result result = formatReader.decode(binaryBitmap, null);

            System.out.println("解析结果：" + result.toString());
            System.out.println("格式类型：" + result.getBarcodeFormat());
            System.out.println("文本内容：" + result.getText());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
