package com.myimooc.excel.boot.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 导入数据明细表
 *
 * @author zc 2017-07-08
 */
@Entity
@Table(name = "import_data_detail")
public class ImportDataDetail {

    /**
     * 导入数据明细ID
     */
    @Id
    private Long id;
    /**
     * 导入数据主表ID
     */
    @Column(name = "importId")
    private Long importId;
    /**
     * 处理状态
     */
    @Column(name = "dealStatus")
    private String dealStatus;
    /**
     * 处理失败编码
     */
    @Column(name = "dealFailCode")
    private String dealFailCode;
    /**
     * 处理失败信息
     */
    @Column(name = "dealFailMsg")
    private String dealFailMsg;

    /**
     * 以下为导入数据字段名称
     */
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

    @Override
    public String toString() {
        return "ImportDataDetail{" +
                "id=" + id +
                ", importId=" + importId +
                ", dealStatus='" + dealStatus + '\'' +
                ", dealFailCode='" + dealFailCode + '\'' +
                ", dealFailMsg='" + dealFailMsg + '\'' +
                ", col0='" + col0 + '\'' +
                ", col1='" + col1 + '\'' +
                ", col2='" + col2 + '\'' +
                ", col3='" + col3 + '\'' +
                ", col4='" + col4 + '\'' +
                ", col5='" + col5 + '\'' +
                ", col6='" + col6 + '\'' +
                ", col7='" + col7 + '\'' +
                ", col8='" + col8 + '\'' +
                ", col9='" + col9 + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getImportId() {
        return importId;
    }

    public void setImportId(Long importId) {
        this.importId = importId;
    }

    public String getDealStatus() {
        return dealStatus;
    }

    public void setDealStatus(String dealStatus) {
        this.dealStatus = dealStatus;
    }

    public String getDealFailCode() {
        return dealFailCode;
    }

    public void setDealFailCode(String dealFailCode) {
        this.dealFailCode = dealFailCode;
    }

    public String getDealFailMsg() {
        return dealFailMsg;
    }

    public void setDealFailMsg(String dealFailMsg) {
        this.dealFailMsg = dealFailMsg;
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
