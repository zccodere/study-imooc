package com.myimooc.spring.auth.common;

import java.io.Serializable;

/**
 * Ajax请求响应对象
 *
 * @author zc 2017-08-19
 */
public class AjaxResult implements Serializable {

    public static final Integer AJAX_STATUS_CODE_SUCCESS = 0;
    public static final Integer AJAX_STATUS_CODE_WARN = 1;
    public static final Integer AJAX_STATUS_CODE_ERROR = 2;

    private static final long serialVersionUID = 1L;

    private Integer statusCode;

    private String message;

    public static AjaxResult success() {
        AjaxResult ajaxResult = new AjaxResult();
        ajaxResult.setStatusCode(AJAX_STATUS_CODE_SUCCESS);
        ajaxResult.setMessage("操作成功");
        return ajaxResult;
    }

    public static AjaxResult error() {
        AjaxResult ajaxResult = new AjaxResult();
        ajaxResult.setStatusCode(AJAX_STATUS_CODE_ERROR);
        return ajaxResult;
    }

    public static AjaxResult warn() {
        AjaxResult ajaxResult = new AjaxResult();
        ajaxResult.setStatusCode(AJAX_STATUS_CODE_WARN);
        return ajaxResult;
    }

    public AjaxResult() {
        super();
    }

    public AjaxResult(Integer statusCode, String message) {
        super();
        this.statusCode = statusCode;
        this.message = message;
    }

    @Override
    public String toString() {
        return "AjaxResult [statusCode=" + statusCode + ", message=" + message + "]";
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}
