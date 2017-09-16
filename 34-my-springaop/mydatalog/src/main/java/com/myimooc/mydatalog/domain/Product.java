package com.myimooc.mydatalog.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.myimooc.mydatalog.datalog.Datalog;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @title 产品实体类
 * @describe 产品信息
 * @author zc
 * @version 1.0 2017-09-13
 */
@Entity
public class Product {

    @Id
    @GeneratedValue
    private Long id;

    @Datalog("产品名称")
    private String name;
    
    /** 类别 */
    private String category;
    /** 详情 */
    private String detail;
    /** 买入价 */
    private BigDecimal buyPrice;
    /** 卖出价 */
    private BigDecimal sellPrice;
    /** 供应商 */
    private String provider;
    /** 上线时间 */
    private Date onlineTime;
    /** 更新时间 */
    private Date updateTime;

    public Product() {
    }

    public Product(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public BigDecimal getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(BigDecimal buyPrice) {
        this.buyPrice = buyPrice;
    }

    public BigDecimal getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(BigDecimal sellPrice) {
        this.sellPrice = sellPrice;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public Date getOnlineTime() {
        return onlineTime;
    }

    public void setOnlineTime(Date onlineTime) {
        this.onlineTime = onlineTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
