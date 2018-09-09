package com.myimooc.boot.small.server.mapper;

import com.myimooc.boot.small.server.po.Area;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <br>
 * 标题: 区域表 DAO<br>
 * 描述: tb_area 表 DAO<br>
 *
 * @author zc
 * @date 2018/04/17
 */
@Repository
public interface AreaMapper {
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
    Integer create(Area area);

    /**
     * 修改区域
     *
     * @param area 区域 PO
     * @return 影响记录数
     */
    Integer update(Area area);

    /**
     * 删除区域
     *
     * @param areaId 区域ID
     * @return 影响记录数
     */
    Integer delete(Integer areaId);
}
