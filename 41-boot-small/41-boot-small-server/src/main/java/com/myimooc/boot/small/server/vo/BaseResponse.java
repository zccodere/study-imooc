package com.myimooc.boot.small.server.vo;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * <br>
 * 标题: Http请求响应基类<br>
 * 描述: 响应请求是否处理成功<br>
 *
 * @author zc
 * @date 2018/04/17
 */
public class BaseResponse implements Serializable {

    private static final long serialVersionUID = -9091805407931758357L;
    /**
     * 状态：true 成功；false 失败；
     */
    private Boolean success;
    /**
     * 错误消息
     */
    private String errMsg;
    /**
     * 响应数据
     */
    private Map<String,Object> data;

    public void putData(String key,Object value){
        this.initData();
        this.data.put(key,value);
    }

    public Object getData(String key){
        this.initData();
        return this.data.get(key);
    }

    private void initData(){
        if (data == null){
            data = new HashMap<>(16);
        }
    }

    public Map<String, Object> getData() {
        return data;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }
}
