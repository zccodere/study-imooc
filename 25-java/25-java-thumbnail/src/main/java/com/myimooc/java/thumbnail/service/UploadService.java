package com.myimooc.java.thumbnail.service;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * 图片上传服务类
 *
 * @author zc 2017-07-19
 */
@Service
public class UploadService {

    private static Logger logger = LoggerFactory.getLogger(UploadService.class);

    public String uploadImage(MultipartFile file, String uploadPath, String realUploadPath) {

        logger.info("上传的相对路径：{}", uploadPath);
        logger.info("上传的绝对路径：{}", realUploadPath);

        String filePath = realUploadPath + file.getOriginalFilename();

        try {
            File targetFile = new File(filePath);
            logger.info("将图片写入文件：" + filePath);
            FileUtils.writeByteArrayToFile(targetFile, file.getBytes());
        } catch (IOException e) {
            logger.info("图片写入失败");
            e.printStackTrace();
        }
        return uploadPath + "/" + file.getOriginalFilename();
    }
}
