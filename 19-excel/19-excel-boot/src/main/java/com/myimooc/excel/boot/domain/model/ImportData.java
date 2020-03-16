package com.myimooc.excel.boot.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 导入数据主表
 *
 * @author zc 2017-07-08
 */
@Entity
@Table(name = "import_data")
public class ImportData {

    /**
     * 导入主表ID
     */
    @Id
    private Long id;
    /**
     * 导入数据类型
     */
    @Column(name = "import_data_type")
    private String importDataType;
    /**
     * 导入时间
     */
    @Column(name = "import_date")
    private String importDate;
    /**
     * 导入状态
     */
    @Column(name = "import_status")
    private String importStatus;
    /**
     * 处理时间
     */
    @Column(name = "deal_date")
    private String dealDate;
    /**
     * 处理状态
     */
    @Column(name = "dealStatus")
    private String dealStatus;

    @Override
    public String toString() {
        return "ImportData{" +
                "id=" + id +
                ", importDataType='" + importDataType + '\'' +
                ", importDate='" + importDate + '\'' +
                ", importStatus='" + importStatus + '\'' +
                ", dealDate='" + dealDate + '\'' +
                ", dealStatus='" + dealStatus + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImportDataType() {
        return importDataType;
    }

    public void setImportDataType(String importDataType) {
        this.importDataType = importDataType;
    }

    public String getImportDate() {
        return importDate;
    }

    public void setImportDate(String importDate) {
        this.importDate = importDate;
    }

    public String getImportStatus() {
        return importStatus;
    }

    public void setImportStatus(String importStatus) {
        this.importStatus = importStatus;
    }

    public String getDealDate() {
        return dealDate;
    }

    public void setDealDate(String dealDate) {
        this.dealDate = dealDate;
    }

    public String getDealStatus() {
        return dealStatus;
    }

    public void setDealStatus(String dealStatus) {
        this.dealStatus = dealStatus;
    }
}
