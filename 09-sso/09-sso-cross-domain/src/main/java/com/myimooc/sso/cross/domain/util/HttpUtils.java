package com.myimooc.sso.cross.domain.util;

import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.Objects;

/**
 * Http请求工具类
 *
 * @author zc 2017-04-02
 */
public class HttpUtils {

    /**
     * 向指定url路径发起get请求
     *
     * @param url   请求路径
     * @param param 请求参数
     * @return 响应对象
     */
    public static RespMessage doGet(String url, Map<String, String> param) {
        RespMessage respMessage = new RespMessage();
        HttpURLConnection connection = null;
        try {
            // 拼装请求参数
            StringBuilder builder = new StringBuilder(url).append("?");
            for (Map.Entry<String, String> entry : param.entrySet()) {
                builder.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
            }
            url = builder.substring(0, builder.length() - 1);

            URL targetUrl = new URL(url);
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

            JSONObject resultJsonMap = JSONObject.parseObject(resultJson.getString("respArgs"));
            respMessage.setRespArgs(resultJsonMap);
            return respMessage;
        } catch (Exception e) {
            respMessage.setRespCode("500");
            respMessage.setRespMsg("请求发起失败");
            return respMessage;
        } finally {
            if (Objects.nonNull(connection)) {
                connection.disconnect();
            }
        }
    }
}
