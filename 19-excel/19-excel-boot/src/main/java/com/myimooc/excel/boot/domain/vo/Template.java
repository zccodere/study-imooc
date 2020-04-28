package com.myimooc.excel.boot.domain.vo;

import java.io.Serializable;

/**
 * 数据导入模版
 *
 * @author zc 2017-07-08
 */
public class Template implements Serializable {

    /**
     * 模版ID
     */
    private String templateId;
    /**
     * 模版名称
     */
    private String templateName;

    @Override
    public String toString() {
        return "Template{" +
                "templateId='" + templateId + '\'' +
                ", templateName='" + templateName + '\'' +
                '}';
    }

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }
}
