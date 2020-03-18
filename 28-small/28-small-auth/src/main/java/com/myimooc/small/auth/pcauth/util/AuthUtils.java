package com.myimooc.small.auth.pcauth.util;

import com.alibaba.fastjson.JSONObject;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

/**
 * 使用Http进行认证请求
 *
 * @author zc 2017-08-12
 */
public class AuthUtils {

    public static final String APPID = "dsadqawer2124a5wdqw1";
    public static final String APPSECRET = "dsadaq875w5edqwd58qwdqwbgthr4t5qa";
    private static final String CHARSET_FORMAT = "UTF-8";

    /**
     * 发起GET请求，并将响应数据封装为JSON
     */
    public static JSONObject doGetJson(String url) throws Exception {
        JSONObject jsonObject = null;
        HttpClientBuilder builder = HttpClientBuilder.create();
        HttpGet httpGet = new HttpGet(url);
        HttpResponse response = builder.build().execute(httpGet);
        HttpEntity entity = response.getEntity();
        if (null != entity) {
            String result = EntityUtils.toString(entity, CHARSET_FORMAT);
            jsonObject = JSONObject.parseObject(result);
        }
        return jsonObject;
    }
}
