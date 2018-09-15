package com.myimooc.sso.cross.domain.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;

/**
 * Http请求工具类
 * @author ZhangCheng
 * @date 2017-04-02
 * @version V1.0
 */
public class HttpUtils {
    
    /**
     * 向指定url路径发起get请求
     * @param url 请求路径
     * @param param 请求参数
     * @return
     */
    public static RespMessage doGet(String url, Map<String,String> param){
        RespMessage respMessage = new RespMessage();
        HttpURLConnection httpURLConnection = null;
        URL targetUrl = null;
        try{
            // 拼装请求参数
            StringBuffer targetUrlStr = new StringBuffer(url).append("?");
            for(Map.Entry<String, String> entry : param.entrySet()){
                targetUrlStr.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
            }
            url = targetUrlStr.substring(0,targetUrlStr.length()-1);
            
            targetUrl = new URL(url);
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
            
            JSONObject resultJsonMap = JSONObject.parseObject(resultJson.getString("respArgs"));
            respMessage.setRespArgs(resultJsonMap);
            return respMessage;
        }catch (Exception e) {
            respMessage.setRespCode("500");
            respMessage.setRespMsg("请求发起失败");
            return respMessage;
        }finally {
            if(httpURLConnection !=null){
                httpURLConnection.disconnect();
            }
        }
    }
}
