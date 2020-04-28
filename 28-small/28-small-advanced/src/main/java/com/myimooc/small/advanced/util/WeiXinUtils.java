package com.myimooc.small.advanced.util;

import com.alibaba.fastjson.JSONObject;
import com.myimooc.small.advanced.domain.menu.Button;
import com.myimooc.small.advanced.domain.menu.ClickButton;
import com.myimooc.small.advanced.domain.menu.Menu;
import com.myimooc.small.advanced.domain.menu.ViewButton;
import com.myimooc.small.advanced.domain.trans.Data;
import com.myimooc.small.advanced.domain.trans.Parts;
import com.myimooc.small.advanced.domain.trans.Symbols;
import com.myimooc.small.advanced.domain.trans.TransResult;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

/**
 * 微信工具类
 *
 * @author zc 2017-08-12
 */
public class WeiXinUtils {

    private static final String UPLOAD_URL = "https://api.weixin.qq.com/cgi-bin/media/upload?access_token=ACCESS_TOKEN&type=TYPE";
    private static final String CREATE_MENU_URL = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
    private static final String QUERY_MENU_URL = "https://api.weixin.qq.com/cgi-bin/menu/get?access_token=ACCESS_TOKEN";
    private static final String DELETE_MENU_URL = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=ACCESS_TOKEN";
    private static final String MEDIA_TYPE_IMAGE = "image";
    private static final String ERROR_NO_0 = "0";
    private static final String EMPTY_ARRAY = "[]";

    public static String upload(String filePath, String accessToken, String type) throws Exception {

        File file = new File(filePath);
        if (!file.exists() || !file.isFile()) {
            throw new IOException("文件不存在");
        }

        String url = UPLOAD_URL.replace("ACCESS_TOKEN", accessToken).replace("TYPE", type);
        URL urlObj = new URL(url);
        // 连接
        HttpURLConnection con = (HttpURLConnection) urlObj.openConnection();
        con.setRequestMethod("POST");
        con.setDoInput(true);
        con.setDoOutput(true);
        con.setUseCaches(false);

        // 设置请求头信息
        con.setRequestProperty("Connection", "Keep-Alive");
        con.setRequestProperty("Charset", "UTF-8");

        // 设置边界
        String boundary = "-----------" + System.currentTimeMillis();
        con.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + boundary);

        StringBuilder sb = new StringBuilder();
        sb.append("--");
        sb.append(boundary);
        sb.append("\r\n");
        sb.append("Content-Disposition;form-data;name=\"file\",filename=\"").append(file.getName()).append("\"\r\n");
        sb.append("Content-Type;application/octet-strean\r\n\r\n");

        byte[] head = sb.toString().getBytes(StandardCharsets.UTF_8);

        // 获得输出流
        OutputStream out = new DataOutputStream(con.getOutputStream());
        // 输出表头
        out.write(head);

        // 文件正文部分    把文件以流文件的方式 推入到url中
        DataInputStream in = new DataInputStream(new FileInputStream(file));
        int bytes = 0;
        byte[] bufferOut = new byte[1024];
        while ((bytes = in.read(bufferOut)) != -1) {
            out.write(bufferOut, 0, bytes);
        }
        in.close();

        // 结尾部分 定义最后数据分隔线
        byte[] foot = ("\r\n--" + boundary + "--\r\n").getBytes(StandardCharsets.UTF_8);

        out.write(foot);
        out.flush();
        out.close();

        StringBuilder buffer = new StringBuilder();
        BufferedReader reader = null;
        String result = null;

        try {
            //定义BufferedReader输入流来读取URL的响应
            reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String line = null;
            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }
            result = buffer.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                reader.close();
            }
        }

        JSONObject jsonObj = JSONObject.parseObject(result);
        System.out.println(jsonObj);
        String typeName = "media_id";
        if (!MEDIA_TYPE_IMAGE.equals(type)) {
            typeName = type + "_media_id";
        }
        return jsonObj.getString(typeName);
    }

    /**
     * 组装菜单
     */
    public static Menu initMenu() {
        Menu menu = new Menu();
        ClickButton button11 = new ClickButton();
        button11.setName("click菜单");
        button11.setType("click");
        button11.setKey("11");

        ViewButton button21 = new ViewButton();
        button21.setName("view菜单");
        button21.setType("view");
        button21.setUrl("http://www.imooc.com");

        ClickButton button31 = new ClickButton();
        button31.setName("扫码事件");
        button31.setType("scancode_push");
        button31.setKey("31");

        ClickButton button32 = new ClickButton();
        button32.setName("地理位置");
        button32.setType("location_select");
        button32.setKey("32");

        Button button = new Button();
        button.setName("菜单");
        button.setSubButton(new Button[]{button31, button32});

        menu.setButton(new Button[]{button11, button21, button});
        return menu;
    }

    /**
     * 创建菜单
     */
    public static int createMenu(String token, String menu) throws Exception {
        int result = 0;
        String url = CREATE_MENU_URL.replace("ACCESS_TOKEN", token);
        JSONObject jsonObject = TokenUtils.doPostStr(url, menu);
        if (jsonObject != null) {
            result = jsonObject.getIntValue("errcode");
        }
        return result;
    }

    /**
     * 获取菜单
     */
    public static JSONObject queryMenu(String token) throws Exception {
        String url = QUERY_MENU_URL.replace("ACCESS_TOKEN", token);
        return TokenUtils.doGetStr(url);
    }

    /**
     * 移除菜单
     */
    public static int deleteMenu(String token) throws Exception {
        String url = DELETE_MENU_URL.replace("ACCESS_TOKEN", token);
        JSONObject jsonObject = TokenUtils.doGetStr(url);
        int result = 0;
        if (jsonObject != null) {
            result = jsonObject.getIntValue("errcode");
        }
        return result;
    }

    /**
     * 词组翻译
     */
    public static String translate(String source) throws Exception {
        String url = "http://openapi.baidu.com/public/2.0/translate/dict/simple?client_id=jNg0LPSBe691Il0CG5MwDupw&q=KEYWORD&from=auto&to=auto";
        url = url.replace("KEYWORD", URLEncoder.encode(source, "UTF-8"));
        JSONObject jsonObject = TokenUtils.doGetStr(url);
        String errno = jsonObject.getString("errno");
        Object obj = jsonObject.get("data");
        StringBuilder result = new StringBuilder();
        if (ERROR_NO_0.equals(errno) && !EMPTY_ARRAY.equals(obj.toString())) {
            TransResult transResult = JSONObject.toJavaObject(jsonObject, TransResult.class);
            Data data = transResult.getData();
            Symbols symbols = data.getSymbols()[0];
            String phZh = symbols.getPhZh() == null ? "" : "中文拼音：" + symbols.getPhZh() + "\n";
            String phEn = symbols.getPhEn() == null ? "" : "英式英标：" + symbols.getPhEn() + "\n";
            String phAm = symbols.getPhAm() == null ? "" : "美式英标：" + symbols.getPhAm() + "\n";
            result.append(phZh).append(phEn).append(phAm);

            Parts[] parts = symbols.getParts();
            String pat;
            for (Parts part : parts) {
                pat = (part.getPart() != null && !"".equals(part.getPart())) ? "[" + part.getPart() + "]" : "";
                String[] means = part.getMeans();
                result.append(pat);
                for (String mean : means) {
                    result.append(mean).append(";");
                }
            }
        } else {
            result.append(translateFull(source));
        }
        return result.toString();
    }

    /**
     * 句子翻译
     */
    private static String translateFull(String source) throws Exception {
        String url = "http://openapi.baidu.com/public/2.0/bmt/translate?client_id=jNg0LPSBe691Il0CG5MwDupw&q=KEYWORD&from=auto&to=auto";
        url = url.replace("KEYWORD", URLEncoder.encode(source, "UTF-8"));
        JSONObject jsonObject = TokenUtils.doGetStr(url);
        StringBuilder dst = new StringBuilder();
        @SuppressWarnings("unchecked")
        List<Map> list = (List<Map>) jsonObject.get("trans_result");
        for (Map map : list) {
            dst.append(map.get("dst"));
        }
        return dst.toString();
    }
}
