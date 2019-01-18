package com.myimooc.excel.boot.domain.vo;

/**
 * 数据导入模版
 * @author ZhangCheng on 2017-07-08
 *
 */
public class Template {
	
	private String templateId;
	
	private String templateName;

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

	@Override
	public String toString() {
		return "Template [templateId=" + templateId + ", templateName=" + templateName + "]";
	}
}
