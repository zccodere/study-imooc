package com.myimooc.sso.same.father.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.alibaba.fastjson.JSONObject;

/**
 * http工具类
 * @author ZhangCheng
 * @date 2017-04-02
 * @version V1.0
 */
public class HttpUtils {
    
    /**
     * 向指定url路径发起get请求，校验cookie
     * @param url 路径
     * @param cookieName
     * @param cookieValue
     * @return
     */
    public static RespMessage doGet(String url, String cookieName, String cookieValue){
        RespMessage respMessage = new RespMessage();
        HttpURLConnection httpURLConnection = null;
        URL targetUrl = null;
        try{
            targetUrl = new URL(url+"?cookieName="+cookieName+"&cookieValue="+cookieValue);
            httpURLConnection = (HttpURLConnection) targetUrl.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.connect();
            
            InputStream in = httpURLConnection.getInputStream();
            InputStreamReader isr = new InputStreamReader(in);
            BufferedReader br = new BufferedReader(isr);
            
            StringBuffer sb = new StringBuffer();
            String temp = null;
            while((temp=br.readLine())!=null){
                sb.append(temp);
            }
            
            br.close();
            isr.close();
            in.close();
            
            JSONObject resultJson = JSONObject.parseObject(sb.toString());
            respMessage.setRespCode(resultJson.getString("respCode"));
            respMessage.setRespMsg(resultJson.getString("respMsg"));
            return respMessage;
        }catch (Exception e) {
            respMessage.setRespCode("500");
            respMessage.setRespMsg("Cookie校验请求失败");
            return respMessage;
        }finally {
            if(httpURLConnection !=null){
                httpURLConnection.disconnect();
            }
        }
    }
    
}
