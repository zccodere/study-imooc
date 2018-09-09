package com.myimooc.rabbitmq.ha.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <br>
 * 标题: FastJson工具类<br>
 * 描述: FastJson工具类<br>
 * 时间: 2018/09/07<br>
 *
 * @author zc
 */
public class FastJsonConvertUtils {

    private static final Logger logger = LoggerFactory.getLogger(FastJsonConvertUtils.class);

    /**
     * 将对象转为JSON字符串
     *
     * @param obj 任意对象
     * @return JSON字符串
     */
    public static String convertObjectToJson(Object obj) {
        try {
            return JSON.toJSONString(obj);
        } catch (Exception ex) {
            logger.warn("将对象转为JSON字符串异常：" + ex);
            throw new RuntimeException("将对象转为JSON字符串异常：" + ex.getMessage(), ex);
        }
    }

    /**
     * 将JSON字符串转为对象
     *
     * @param message JSON字符串
     * @param type    对象
     * @param <T>     对象
     * @return 对象实例
     */
    public static <T> T convertJsonToObject(String message, Class<T> type) {
        try {
            return JSONObject.parseObject(message, type);
        } catch (Exception ex) {
            logger.warn("将JSON字符串转为对象异常：" + ex);
            throw new RuntimeException("将JSON字符串转为对象异常：" + ex.getMessage(), ex);
        }
    }
}
