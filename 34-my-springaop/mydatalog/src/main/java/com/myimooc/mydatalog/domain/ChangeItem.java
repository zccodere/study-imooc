package com.myimooc.mydatalog.domain;

/**
 * @title 变化条目实体类
 * @describe 记录字段信息
 * @author zc
 * @version 1.0 2017-09-13
 */
public class ChangeItem {
	/** 字段名称 */
    private String field;
    /** 字段中文名称 */
    private String fieldShowName;
    /** 字段旧值 */
    private String oldValue;
    /** 字段新值 */
    private String newValue;
   
	@Override
	public String toString() {
		return "ChangeItem [field=" + field + ", fieldShowName=" + fieldShowName + ", oldValue=" + oldValue
				+ ", newValue=" + newValue + "]";
	}

	public String getFieldShowName() {
        return fieldShowName;
    }

    public void setFieldShowName(String fieldShowName) {
        this.fieldShowName = fieldShowName;
    }

    public String getOldValue() {
        return oldValue;
    }

    public void setOldValue(String oldValue) {
        this.oldValue = oldValue;
    }

    public String getNewValue() {
        return newValue;
    }

    public void setNewValue(String newValue) {
        this.newValue = newValue;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }
}
