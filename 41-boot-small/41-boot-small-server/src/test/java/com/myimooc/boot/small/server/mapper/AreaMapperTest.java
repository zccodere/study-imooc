package com.myimooc.boot.small.server.mapper;

import com.myimooc.boot.small.server.BaseTest;
import com.myimooc.boot.small.server.po.Area;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * 区域表 DAO 测试类
 *
 * @author zc 2018-04-17
 */
public class AreaMapperTest extends BaseTest {

    @Autowired
    private AreaMapper areaMapper;

    @Test
    @Ignore
    public void listAll() {
        Assert.assertNotNull(areaMapper);
        List<Area> areas = areaMapper.listAll();
        assertEquals(2, areas.size());
    }

    @Test
    public void findById() {
        Area area = areaMapper.findById(1);
        assertEquals("东苑", area.getAreaName());
    }

    @Test
    @Ignore
    public void create() {
        Area area = new Area();
        area.setAreaName("西苑");
        area.setPriority(2);
        Integer num = areaMapper.create(area);
        assertEquals(new Integer(1), num);
    }

    @Test
    @Ignore
    public void update() {
        Area area = new Area();
        area.setAreaName("东苑");
        area.setAreaId(1);
        area.setLastEditTime(new Date());
        Integer num = areaMapper.update(area);
        assertEquals(new Integer(1), num);
    }

    @Test
    @Ignore
    public void delete() {
        Integer num = areaMapper.delete(3);
        assertEquals(new Integer(1), num);
    }
}
