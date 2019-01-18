package com.myimooc.boot.small.server.service;

import com.myimooc.boot.small.server.po.Area;

import java.util.List;

/**
 * <br>
 * 标题: 区域业务服务<br>
 * 描述: 区域业务服务<br>
 *
 * @author zc
 * @date 2018/04/17
 */
public interface AreaService {

    /**
     * 批量查询
     *
     * @return 区域集合
     */
    List<Area> listAll();

    /**
     * 详情查询
     *
     * @param areaId 区域ID
     * @return 区域信息
     */
    Area findById(Integer areaId);

    /**
     * 创建区域
     *
     * @param area 区域 PO
     * @return 影响记录数
     */
    Boolean create(Area area);

    /**
     * 修改区域
     *
     * @param area 区域 PO
     * @return 影响记录数
     */
    Boolean update(Area area);

    /**
     * 删除区域
     *
     * @param areaId 区域ID
     * @return 影响记录数
     */
    Boolean delete(Integer areaId);

}
