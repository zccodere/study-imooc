package com.myimooc.small.advanced.util;

import com.alibaba.fastjson.JSONObject;
import com.myimooc.small.advanced.domain.AccessToken;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

/**
 * 微信工具类
 *
 * @author zc 2017-08-12
 */
public class TokenUtils {

    private static final String APPID = "dsadqawer2124a5wdqw1";
    private static final String APPSECRET = "dsadaq875w5edqwd58qwdqwbgthr4t5qa";
    private static final String CHARSET_FORMAT = "UTF-8";

    private static final String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
    private static final String ACCESS_TOKEN = "access_token";

    /**
     * 发起GET请求
     */
    public static JSONObject doGetStr(String url) throws Exception {
        HttpClientBuilder builder = HttpClientBuilder.create();
        HttpGet httpGet = new HttpGet(url);
        JSONObject object = null;
        HttpResponse response = builder.build().execute(httpGet);
        HttpEntity entity = response.getEntity();
        if (null != entity) {
            String result = EntityUtils.toString(entity, CHARSET_FORMAT);
            object = JSONObject.parseObject(result);
        }
        return object;
    }

    /**
     * 发起POST请求
     */
    public static JSONObject doPostStr(String url, String outStr) throws Exception {
        HttpClientBuilder builder = HttpClientBuilder.create();
        JSONObject object = null;
        HttpPost httpPost = new HttpPost(url);
        httpPost.setEntity(new StringEntity(outStr, CHARSET_FORMAT));
        HttpResponse response = builder.build().execute(httpPost);
        HttpEntity entity = response.getEntity();
        String result = EntityUtils.toString(entity, CHARSET_FORMAT);
        object = JSONObject.parseObject(result);
        return object;
    }

    /**
     * 获取access_token
     */
    public static AccessToken getAccessToken() {
        AccessToken token = new AccessToken();
        String url = ACCESS_TOKEN_URL.replace("APPID", APPID).replace("APPSECRET", APPSECRET);
        JSONObject json = null;
        try {
            json = doGetStr(url);
        } catch (Exception e) {
        }
        if (null != json && json.containsKey(ACCESS_TOKEN)) {
            token.setToken(json.getString(ACCESS_TOKEN));
            token.setExpiresIn(json.getIntValue("expires_in"));
        }
        return token;
    }
}
