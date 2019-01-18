package com.myimooc.java.watermark.service;

import java.awt.Color;
import java.awt.Font;
import java.io.File;

/**
 * 图片水印服务类
 *
 * @author ZhangCheng on 2017-07-21
 */
public interface MarkService {

    /**
     * 水印文字内容
     */
    public static final String MARK_TEXT = "妙手空空";
    /**
     * 水印文字类型
     */
    public static final String FONT_NAME = "微软雅黑";
    /**
     * 水印文字样式
     */
    public static final int FONT_STYLE = Font.BOLD;
    /**
     * 水印文字大小（单位:像素）
     */
    public static final int FONT_SIZE = 120;
    /**
     * 水印文字颜色
     */
    public static final Color FONT_COLOR = Color.BLACK;
    /**
     * 水印文字位置X轴
     */
    public static final int X = 10;
    /**
     * 水印文字位置Y轴
     */
    public static final int Y = 10;
    /**
     * 水印文字透明度
     */
    public static final float ALPHA = 0.3F;

    /**
     * 水印图片
     */
    public static final String LOGO = "logo.png";

    /**
     * 功能：将传入的图片添加水印并保存到服务器中
     *
     * @param imageFile      文件地址
     * @param imageFileName  文件名称
     * @param uploadPath     上传路径
     * @param realUploadPath 真实上传路径
     * @return 水印后的地址
     */
    String watermake(File imageFile, String imageFileName, String uploadPath, String realUploadPath);

}
