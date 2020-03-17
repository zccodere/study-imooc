package com.myimooc.java.watermark.controller;

import com.myimooc.java.watermark.domain.PicInfo;
import com.myimooc.java.watermark.service.MarkService;
import com.myimooc.java.watermark.service.UploadService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * WatermarkController 控制类
 *
 * @author zc 2017-07-21
 */
@Controller
public class WatermarkController {

    private static Logger logger = LoggerFactory.getLogger(WatermarkController.class);

    @Autowired
    private UploadService uploadService;

    @Autowired
    private MarkService markService;

    /***
     * 单图片上传
     *
     * @param image 图片文件
     * @return 图片信息
     */
    @PostMapping("/watermark")
    public ModelAndView watermark(MultipartFile image) {
        ModelAndView mav = new ModelAndView("/watermark");
        PicInfo picInfo = new PicInfo();

        String uploadPath = "static/images/";
        String realUploadPath = this.getRealUploadPath();

        String imageUrl = uploadService.uploadImage(image, uploadPath, realUploadPath);

        File imageFile = new File(realUploadPath + image.getOriginalFilename());

        String logoImageUrl = markService.watermake(imageFile, image.getOriginalFilename(), uploadPath, realUploadPath);

        picInfo.setImageUrl(imageUrl);
        picInfo.setLogoImageUrl(logoImageUrl);
        mav.addObject("picInfo", picInfo);

        return mav;
    }

    /**
     * 图片批量上传
     */
    @PostMapping("/more-watermark")
    public ModelAndView moreWatermark(List<MultipartFile> image) {
        ModelAndView mav = new ModelAndView("/more-watermark");

        String uploadPath = "static/images/";
        String realUploadPath = this.getRealUploadPath();

        if (image != null && image.size() > 0) {
            List<PicInfo> picInfoList = new ArrayList<>();
            for (MultipartFile imageFileTemp : image) {
                if (imageFileTemp == null || imageFileTemp.getSize() < 1) {
                    continue;
                }
                PicInfo picInfo = new PicInfo();
                String imageUrl = uploadService.uploadImage(imageFileTemp, uploadPath, realUploadPath);
                File imageFile = new File(realUploadPath + imageFileTemp.getOriginalFilename());
                String logoImageUrl = markService.watermake(imageFile, imageFileTemp.getOriginalFilename(), uploadPath, realUploadPath);
                picInfo.setImageUrl(imageUrl);
                picInfo.setLogoImageUrl(logoImageUrl);
                picInfoList.add(picInfo);
            }
            mav.addObject("picInfoList", picInfoList);
        }
        return mav;
    }

    private String getRealUploadPath() {
        String uploadPath = "static/images/";
        URL resource = getClass().getClassLoader().getResource(uploadPath);
        if (Objects.isNull(resource)) {
            throw new RuntimeException("获取资源失败");
        }
        String realUploadPath = resource.getPath();
        logger.info("上传相对目录：{}", uploadPath);
        logger.info("上传绝对目录：{}", realUploadPath);
        return realUploadPath;
    }
}
