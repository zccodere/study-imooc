package com.myimooc.sso.same.father.util;

import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Objects;

/**
 * http工具类
 *
 * @author zc 2020-03-15
 */
public class HttpUtils {

    /**
     * 向指定url路径发起get请求，校验cookie
     *
     * @param url         路径
     * @param cookieName  cookie 名称
     * @param cookieValue cookie 值
     * @return 响应对象
     */
    public static RespMessage doGet(String url, String cookieName, String cookieValue) {
        RespMessage respMessage = new RespMessage();
        HttpURLConnection connection = null;
        try {
            URL targetUrl = new URL(url + "?cookieName=" + cookieName + "&cookieValue=" + cookieValue);
            connection = (HttpURLConnection) targetUrl.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            InputStream in = connection.getInputStream();
            InputStreamReader isr = new InputStreamReader(in);
            BufferedReader br = new BufferedReader(isr);

            StringBuilder sb = new StringBuilder();
            String temp;
            while ((temp = br.readLine()) != null) {
                sb.append(temp);
            }

            br.close();
            isr.close();
            in.close();

            JSONObject resultJson = JSONObject.parseObject(sb.toString());
            respMessage.setRespCode(resultJson.getString("respCode"));
            respMessage.setRespMsg(resultJson.getString("respMsg"));
            return respMessage;
        } catch (Exception e) {
            respMessage.setRespCode("500");
            respMessage.setRespMsg("Cookie校验请求失败");
            return respMessage;
        } finally {
            if (Objects.nonNull(connection)) {
                connection.disconnect();
            }
        }
    }
}
