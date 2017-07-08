package com.myimooc.myexcelweb.domain.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 导入数据明细表
 * @author ZhangCheng on 2017-07-08
 *
 */
@Entity
@Table(name="import_data_detail")
public class ImportDataDetail {
	
	@Id
	private Long id;// 导入数据明细ID
	
	private Long import_id;// 导入数据主表ID
	
	private String deal_status;// 处理状态
	
	private String deal_fail_code; // 处理失败编码
	
	private String deal_fail_msg;// 处理失败信息
	
	// 以下为导入数据字段名称
	private String col0;
	private String col1;
	private String col2;
	private String col3;
	private String col4;
	private String col5;
	private String col6;
	private String col7;
	private String col8;
	private String col9;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getImport_id() {
		return import_id;
	}
	public void setImport_id(Long import_id) {
		this.import_id = import_id;
	}
	public String getDeal_status() {
		return deal_status;
	}
	public void setDeal_status(String deal_status) {
		this.deal_status = deal_status;
	}
	public String getDeal_fail_code() {
		return deal_fail_code;
	}
	public void setDeal_fail_code(String deal_fail_code) {
		this.deal_fail_code = deal_fail_code;
	}
	public String getDeal_fail_msg() {
		return deal_fail_msg;
	}
	public void setDeal_fail_msg(String deal_fail_msg) {
		this.deal_fail_msg = deal_fail_msg;
	}
	public String getCol0() {
		return col0;
	}
	public void setCol0(String col0) {
		this.col0 = col0;
	}
	public String getCol1() {
		return col1;
	}
	public void setCol1(String col1) {
		this.col1 = col1;
	}
	public String getCol2() {
		return col2;
	}
	public void setCol2(String col2) {
		this.col2 = col2;
	}
	public String getCol3() {
		return col3;
	}
	public void setCol3(String col3) {
		this.col3 = col3;
	}
	public String getCol4() {
		return col4;
	}
	public void setCol4(String col4) {
		this.col4 = col4;
	}
	public String getCol5() {
		return col5;
	}
	public void setCol5(String col5) {
		this.col5 = col5;
	}
	public String getCol6() {
		return col6;
	}
	public void setCol6(String col6) {
		this.col6 = col6;
	}
	public String getCol7() {
		return col7;
	}
	public void setCol7(String col7) {
		this.col7 = col7;
	}
	public String getCol8() {
		return col8;
	}
	public void setCol8(String col8) {
		this.col8 = col8;
	}
	public String getCol9() {
		return col9;
	}
	public void setCol9(String col9) {
		this.col9 = col9;
	}
}
