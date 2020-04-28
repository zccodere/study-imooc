package com.myimooc.java.image.code.generator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.Set;
import java.util.UUID;

import javax.imageio.ImageIO;

/**
 * 生成验证码图片核心类
 *
 * @author zc 2017-07-09
 */
public class Image {

    private static final Logger log = LoggerFactory.getLogger(Image.class);

    private static Map<String, ImageGroup> imageGroupMap = new HashMap<>(32);
    private static Map<Integer, Map<String, ImageGroup>> countGroupMap = new HashMap<>(32);

    /**
     * 功能：由小图生成一种大图
     */
    public static ImageResult generateImage() throws IOException {
        // 初始化
        initImageGroup();
        log.debug("初始化完成");
        GenerateImageGroup generateImageGroup = randomImageGroups();
        List<BufferedImageWrap> images = new ArrayList<>();
        // 找到图片干扰项
        for (ImageGroup group : generateImageGroup.getGroups()) {
            for (String imgName : group.getImages()) {
                images.add(new BufferedImageWrap(false, getBufferedImage(imgName)));
            }
        }
        // 找到图片答案项
        for (String imgName : generateImageGroup.getKeyGroup().getImages()) {
            images.add(new BufferedImageWrap(true, getBufferedImage(imgName)));
        }
        return mergeImage(images, generateImageGroup.getKeyGroup().getName());
    }

    /**
     * 功能：根据图片名称获得图片缓冲流
     */
    private static BufferedImage getBufferedImage(String imgName) throws IOException {
        URL resource = Image.class.getClassLoader().getResource("sourceImage/");
        if (Objects.isNull(resource)) {
            throw new IOException("获取资源失败");
        }

        String rootPath = resource.getPath();
        String imgPath = rootPath + imgName;
        File file = new File(imgPath);
        return ImageIO.read(file);
    }

    /**
     * 功能：将小图合并成一种大图
     */
    private static ImageResult mergeImage(List<BufferedImageWrap> imageWraps, String tip) {
        Collections.shuffle(imageWraps);
        // 原始图片宽200像素，高200像素
        int width = 200;
        int high = 200;
        int totalWidth = width * 4;

        BufferedImage destImage = new BufferedImage(totalWidth, 400, BufferedImage.TYPE_INT_RGB);
        int x1 = 0;
        int x2 = 0;
        int order = 0;
        StringBuilder keysOrder = new StringBuilder();
        Set<Integer> keySet = new HashSet<>();
        for (BufferedImageWrap image : imageWraps) {
            int[] rgb = image.getBufferedImage().getRGB(0, 0, width, high, null, 0, width);
            if (image.isKey()) {
                int x = (order % 4) * 200;
                int y = order < 4 ? 0 : 200;
                keySet.add(order);
                keysOrder.append(order).append("(").append(x).append(",").append(y).append(")|");
            }
            if (order < 4) {
                // 设置上半部分的RGB
                destImage.setRGB(x1, 0, width, high, rgb, 0, width);
                x1 += width;
            } else {
                destImage.setRGB(x2, high, width, high, rgb, 0, width);
                x2 += width;
            }
            order++;
        }

        keysOrder.deleteCharAt(keysOrder.length() - 1);
        System.out.println("答案位置：" + keysOrder);
        String fileName = UUID.randomUUID().toString().replaceAll("-", "") + ".jpeg";
        URL resource = Image.class.getClassLoader().getResource("static/targetImage/");
        if (Objects.isNull(resource)) {
            throw new RuntimeException("获取资源失败");
        }
        String rootPath = resource.getPath();
        log.info("根路径：{}", rootPath);
        String fileUrl = rootPath + fileName;
        // 保存图片
        saveImage(destImage, fileUrl);

        ImageResult ir = new ImageResult();
        ir.setName(fileName);
        ir.setKeySet(keySet);
        ir.setUniqueKey(fileName);
        ir.setTip(tip);
        return ir;
    }

    /**
     * 功能：将图片写入指定的路径
     */
    private static void saveImage(BufferedImage destImage, String fileUrl) {
        File file = new File(fileUrl);
        log.debug(file.getAbsolutePath());
        try {
            ImageIO.write(destImage, "png", file);
        } catch (IOException ex) {
            log.error("图片写入失败：", ex);
        }
    }

    /**
     * 功能：随机生成图片答案和干扰组
     */
    private static GenerateImageGroup randomImageGroups() {

        int num = random(0, imageGroupMap.size() - 1);

        String name = new ArrayList<>(imageGroupMap.keySet()).get(num);
        ImageGroup keyGroup = imageGroupMap.get(name);

        Map<Integer, Map<String, ImageGroup>> thisCountGroupMap = new HashMap<>(countGroupMap);
        thisCountGroupMap.get(keyGroup.getCount()).remove(name);

        // 假设总量8个，每种名称图片只有2个或4个，为了逻辑简单些
        int otherImageCount = 8 - keyGroup.getCount();

        int leftCount4 = 4;
        int leftCount2 = 2;

        List<ImageGroup> result = new ArrayList<>(8);
        if (otherImageCount == leftCount4) {
            // 需要另外4个混淆图片
            if (new Random().nextInt() % leftCount2 == 0) {
                List<ImageGroup> groups = new ArrayList<>(thisCountGroupMap.get(4).values());
                if (groups.size() > 1) {
                    num = random(0, groups.size() - 1);
                } else {
                    num = 0;
                }
                result.add(groups.get(num));
            } else {
                List<ImageGroup> groups = new ArrayList<>(thisCountGroupMap.get(2).values());
                int num1 = random(0, groups.size() - 1);
                result.add(groups.get(num1));

                int num2 = random(0, groups.size() - 1, num1);
                result.add(groups.get(num2));
            }
            return new GenerateImageGroup(keyGroup, result);
        }

        // 需要另外6个混淆图片
        if (new Random().nextInt() % leftCount2 == 0) {
            List<ImageGroup> groups1 = new ArrayList<>(thisCountGroupMap.get(4).values());
            int num1 = random(0, groups1.size() - 1);
            result.add(groups1.get(num1));

            List<ImageGroup> groups2 = new ArrayList<>(thisCountGroupMap.get(2).values());
            int num2 = random(0, groups2.size() - 1);
            result.add(groups2.get(num2));
        } else {
            List<ImageGroup> groups = new ArrayList<>(thisCountGroupMap.get(2).values());
            int num1 = random(0, groups.size() - 1);
            result.add(groups.get(num1));

            int num2 = random(0, groups.size() - 1, num1);
            result.add(groups.get(num2));

            int num3 = random(0, groups.size() - 1, num1, num2);
            result.add(groups.get(num3));
        }
        return new GenerateImageGroup(keyGroup, result);
    }

    /**
     * 功能：初始化图片组。后期优化可从数据库获取
     */
    private static void initImageGroup() {
        ImageGroup group1 = new ImageGroup("包包", 4, "bao/1.jpg", "bao/2.jpg", "bao/3.jpg", "bao/4.jpg");
        ImageGroup group2 = new ImageGroup("老虎", 4, "laohu/1.jpg", "laohu/2.jpg", "laohu/3.jpg", "laohu/4.jpg");
        ImageGroup group3 = new ImageGroup("糖葫芦", 4, "tanghulu/1.jpg", "tanghulu/2.jpg", "tanghulu/3.jpg", "tanghulu/4.jpg");
        ImageGroup group4 = new ImageGroup("小慕", 4, "xiaomu/1.jpg", "xiaomu/2.jpg", "xiaomu/3.jpg", "xiaomu/4.jpg");
        ImageGroup group5 = new ImageGroup("柚子", 4, "youzi/1.jpg", "youzi/2.jpg", "youzi/3.jpg", "youzi/4.jpg");
        ImageGroup group6 = new ImageGroup("订书机", 2, "dingshuji/1.jpg", "dingshuji/2.jpg");
        ImageGroup group7 = new ImageGroup("蘑菇", 2, "mogu/1.jpg", "mogu/2.jpg");
        ImageGroup group8 = new ImageGroup("磁铁", 2, "citie/1.jpg", "citie/2.jpg");
        ImageGroup group9 = new ImageGroup("土豆", 4, "tudou/1.jpg", "tudou/2.jpg", "tudou/3.jpg", "tudou/4.jpg");
        ImageGroup group10 = new ImageGroup("兔子", 4, "tuzi/1.jpg", "tuzi/2.jpg", "tuzi/3.jpg", "tuzi/4.jpg");
        ImageGroup group11 = new ImageGroup("仙人球", 4, "xianrenqiu/1.jpg", "xianrenqiu/2.jpg", "xianrenqiu/3.jpg", "xianrenqiu/4.jpg");

        initMap(group1, group2, group3, group4, group5, group6, group7, group8, group9, group10, group11);
    }

    /**
     * 功能：初始化所有图片组
     */
    private static void initMap(ImageGroup... groups) {
        for (ImageGroup group : groups) {
            imageGroupMap.put(group.getName(), group);
            if (!countGroupMap.containsKey(group.getCount())) {
                countGroupMap.put(group.getCount(), new HashMap<>(64));
            }
            countGroupMap.get(group.getCount()).put(group.getName(), group);
        }
    }

    /**
     * 功能：生成随机整数
     */
    private static int random(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

    /**
     * 功能：生成随机整数不在指定整数数组里
     */
    private static int random(int min, int max, Integer... not) {
        int num = random(0, max);
        List<Integer> notList = Arrays.asList(not);
        while (notList.contains(num)) {
            num = random(0, max);
        }
        return num;
    }
}
