//package com.myimooc.qrcode.simple;
//
//import java.awt.Color;
//import java.awt.Graphics2D;
//import java.awt.image.BufferedImage;
//import java.io.File;
//import javax.imageio.ImageIO;
//
//import com.swetake.util.Qrcode;
//
///**
// * 生成 二维码 通过 Qrcode
// *
// * @author ZhangCheng on 2017-06-23
// */
//public class CreateQrcode {
//
//    public static void main(String[] args) throws Exception {
//
//        Qrcode x = new Qrcode();
//
//        // 二维码显示的内容
//        String qrData = "www.imooc.com";
//        int version = 7;
//        int width = 67 + 12 * (version - 1);
//        int height = 67 + 12 * (version - 1);
//        // 纠错等级：设置二维码排错率，可选L(7%)、M(15%)、Q(25%)、H(30%)，排错率越高可存储的信息越少，但对二维码清晰
//        x.setQrcodeErrorCorrect('M');
//        // N代表数字，A代表z-Z，B代表其他字符
//        x.setQrcodeEncodeMode('B');
//        // 设置设置版本号，取值范围1-40，值越大尺寸越大，可存储的信息越大
//        x.setQrcodeVersion(version);
//
//        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
//        Graphics2D gs = bufferedImage.createGraphics();
//        // 设置属性
//        gs.setBackground(Color.WHITE);
//        gs.setColor(Color.BLACK);
//        gs.clearRect(0, 0, width, height);
//
//        // 偏移量
//        int pixoff = 2;
//
//        byte[] d = qrData.getBytes("gb2312");
//        int length = 120;
//        if (d.length > 0 && d.length < length) {
//            boolean[][] s = x.calQrcode(d);
//
//            for (int i = 0; i < s.length; i++) {
//                for (int j = 0; j < s.length; j++) {
//                    if (s[j][i]) {
//                        gs.fillRect(j * 3 + pixoff, i * 3 + pixoff, 3, 3);
//                    }
//                }
//            }
//        }
//
//        gs.dispose();
//        bufferedImage.flush();
//
//        ImageIO.write(bufferedImage, "png", new File("D:/qrcode.png"));
//    }
//
//}
