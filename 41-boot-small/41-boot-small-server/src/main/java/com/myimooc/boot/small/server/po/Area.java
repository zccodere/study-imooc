package com.myimooc.boot.small.server.po;

import java.io.Serializable;
import java.util.Date;

/**
 * <br>
 * 标题: 区域表PO<br>
 * 描述: tb_area 表PO<br>
 *
 * @author zc
 * @date 2018/04/16
 */
public class Area implements Serializable {

    private static final long serialVersionUID = -3084550177471749048L;
    /**
     * 主键 区域 ID
     */
    private Integer areaId;
    /**
     * 区域名称
     */
    private String areaName;
    /**
     * 权重，越大越排前显示
     */
    private Integer priority;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 最后一次修改时间
     */
    private Date lastEditTime;

    @Override
    public String toString() {
        return "Area{" +
                "areaId=" + areaId +
                ", areaName='" + areaName + '\'' +
                ", priority=" + priority +
                ", createTime=" + createTime +
                ", lastEditTime=" + lastEditTime +
                '}';
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastEditTime() {
        return lastEditTime;
    }

    public void setLastEditTime(Date lastEditTime) {
        this.lastEditTime = lastEditTime;
    }
}
