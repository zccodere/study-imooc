package com.myimooc.java.thumbnail.service;

import net.coobird.thumbnailator.Thumbnails;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * 缩略图服务类
 *
 * @author zc 2017-07-19
 */
@Service
public class ThumbnailService {

    private static final int WIDTH = 100;
    private static final int HEIGHT = 100;

    public String thumbnail(MultipartFile file, String uploadPath, String realUploadPath) {
        try {
            String des = realUploadPath + "/thumbnail_" + file.getOriginalFilename();
            Thumbnails.of(file.getInputStream()).size(WIDTH, HEIGHT).toFile(des);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return uploadPath + "/thumbnail_" + file.getOriginalFilename();
    }
}
