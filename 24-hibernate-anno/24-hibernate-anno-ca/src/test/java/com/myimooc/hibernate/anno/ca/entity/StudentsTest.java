package com.myimooc.hibernate.anno.ca.entity;

import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.hibernate.tool.schema.TargetType;
import org.junit.Test;

import java.util.EnumSet;

/**
 * 测试类
 *
 * @author zc 2017-07-12
 */
public class StudentsTest {

    @Test
    public void schemaExportTest() {
        // 创建服务注册对象
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
        // 构建元数据
        Metadata metadata = new MetadataSources(serviceRegistry).buildMetadata();

        SchemaExport export = new SchemaExport();
        export.create(EnumSet.of(TargetType.DATABASE), metadata);
    }
}
