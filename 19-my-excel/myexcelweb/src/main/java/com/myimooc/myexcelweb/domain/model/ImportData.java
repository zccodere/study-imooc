package com.myimooc.myexcelweb.domain.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 导入数据主表
 * @author ZhangCheng on 2017-07-08
 *
 */
@Entity
@Table(name="import_data")
public class ImportData {
	
	@Id
	private Long id;// 导入主表ID
	
	private String import_data_type;// 导入数据类型
	
	private String import_date;// 导入时间
	
	private String import_status;// 导入状态
	
	private String deal_date;// 处理时间
	
	private String deal_status;// 处理状态

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getImport_data_type() {
		return import_data_type;
	}

	public void setImport_data_type(String import_data_type) {
		this.import_data_type = import_data_type;
	}

	public String getImport_date() {
		return import_date;
	}

	public void setImport_date(String import_date) {
		this.import_date = import_date;
	}

	public String getImport_status() {
		return import_status;
	}

	public void setImport_status(String import_status) {
		this.import_status = import_status;
	}

	public String getDeal_date() {
		return deal_date;
	}

	public void setDeal_date(String deal_date) {
		this.deal_date = deal_date;
	}

	public String getDeal_status() {
		return deal_status;
	}

	public void setDeal_status(String deal_status) {
		this.deal_status = deal_status;
	}

	@Override
	public String toString() {
		return "ImportData [id=" + id + ", import_data_type=" + import_data_type + ", import_date=" + import_date
				+ ", import_status=" + import_status + ", deal_date=" + deal_date + ", deal_status=" + deal_status
				+ "]";
	}
}
