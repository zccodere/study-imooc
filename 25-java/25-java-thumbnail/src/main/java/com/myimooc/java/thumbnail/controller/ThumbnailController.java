package com.myimooc.java.thumbnail.controller;

import com.myimooc.java.thumbnail.service.ThumbnailService;
import com.myimooc.java.thumbnail.service.UploadService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.net.URL;
import java.util.Objects;

/**
 * Thumbnail 控制层
 *
 * @author zc 2017-07-19
 */
@Controller
@RequestMapping("/")
public class ThumbnailController {

    private static Logger logger = LoggerFactory.getLogger(ThumbnailController.class);

    @Autowired
    private UploadService uploadService;
    @Autowired
    private ThumbnailService thumbnailService;

    @PostMapping("thumbnail")
    public ModelAndView thumbnail(MultipartFile image) {

        ModelAndView mav = new ModelAndView();

        String uploadPath = "static/images/";
        URL resource = getClass().getClassLoader().getResource(uploadPath);
        if (Objects.isNull(resource)) {
            throw new RuntimeException("获取资源失败");
        }

        String realUploadPath = resource.getPath();

        logger.info("上传相对目录：{}", uploadPath);
        logger.info("上传绝对目录：{}", uploadPath);

        String imageUrl = uploadService.uploadImage(image, uploadPath, realUploadPath);
        String thumbnailImageUrl = thumbnailService.thumbnail(image, uploadPath, realUploadPath);

        mav.addObject("imageUrl", imageUrl);
        mav.addObject("thumbnailImageUrl", thumbnailImageUrl);
        mav.setViewName("thumbnail");
        return mav;
    }
}
