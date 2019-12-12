package com.myimooc.ajax.server.vo;

import java.io.Serializable;

/**
 * <br>
 * 标题: REST请求响应POJO类<br>
 * 描述: 封装请求响应结果<br>
 *
 * @author zc
 * @date 2018/04/18
 */
public class ResultBean implements Serializable{

    private static final long serialVersionUID = 7867107433319736719L;

    private String data;

    public ResultBean(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
