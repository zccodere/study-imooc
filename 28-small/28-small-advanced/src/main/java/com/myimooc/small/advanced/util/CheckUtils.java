package com.myimooc.small.advanced.util;

import com.myimooc.small.advanced.domain.AccessReqVo;

import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Objects;

/**
 * 开发模式接入-服务器验证-校验工具类
 *
 * @author zc 2017-08-11
 */
public class CheckUtils {

    private static final Logger logger = LoggerFactory.getLogger(CheckUtils.class);

    /**
     * 开发者模式-开发者自己填写的 TOKEN （令牌）
     */
    private static final String TOKEN = "myimooc";

    /**
     * 功能：验证消息的确来自微信服务器
     */
    public static boolean checkSignature(AccessReqVo vo) {

        logger.info("验证：{}", vo.toString());

        String[] arr = new String[]{TOKEN, vo.getTimestamp(), vo.getNonce()};
        // 排序
        Arrays.sort(arr);
        // 生成字符串
        StringBuilder content = new StringBuilder();
        for (String s : arr) {
            content.append(s);
        }
        // sha1加密
        String temp = getSha1(content.toString());
        logger.info("sha1 微信传入密文：{}", vo.getSignature());
        return Objects.equals(vo.getSignature(), temp);
    }

    /**
     * 通过 JDK 实现SHA-1 加密
     */
    private static String getSha1(String str) {
        logger.info("sha1 加密前字符串：{}", str);
        try {
            MessageDigest md = MessageDigest.getInstance("SHA1");
            md.update(str.getBytes());
            String result = DigestUtils.sha1Hex(md.digest());
            logger.info("sha1 加密后字符串：{}", result);
            return result;
        } catch (Exception ex) {
            logger.error("sha1 加密异常：", ex);
        }
        return null;
    }
}
