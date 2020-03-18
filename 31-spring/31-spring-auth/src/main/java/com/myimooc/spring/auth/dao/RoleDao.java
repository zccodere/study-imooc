package com.myimooc.spring.auth.dao;

import com.myimooc.spring.auth.common.BaseDao;
import com.myimooc.spring.auth.common.IdUtils;
import com.myimooc.spring.auth.entity.Role;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 角色Dao
 *
 * @author zc 2017-08-19
 */
@Repository
public class RoleDao extends BaseDao {

    /**
     * 保存角色
     */
    public void save(Role role) {
        String sql = "insert into auth_role(id,name) values(?,?)";
        role.setId(IdUtils.getDateTimeStr());
        jdbcTemplate.update(sql, role.getId(), role.getName());
    }

    /**
     * 根据ID删除角色
     */
    public void deleteById(Long id) {
        String sql = "delete from auth_role where id = ?";
        jdbcTemplate.update(sql, id);
    }

    /**
     * 更新角色
     */
    public void update(Role role) {
        String sql = "update auth_role set name = ?,id = ? where id = ?";
        jdbcTemplate.update(sql, role.getName(), role.getId(), role.getId());
    }

    /**
     * 根据ID查询角色
     */
    public Role findById(Long id) {
        String sql = "select * from auth_role where id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new RoleMapper());
    }

    /**
     * 分页查询
     *
     * @param page 页码，第n页
     * @param size 每页记录数
     * @return 行记录集合
     */
    public List<Role> findByPage(int page, int size) {
        if (page < 1) {
            page = 1;
        }
        if (size < 0) {
            size = 20;
        }
        String sql = "select * from auth_role limit ?,?";
        int skip = (page - 1) * size;
        return jdbcTemplate.query(sql, new Object[]{skip, size}, new RoleMapper());
    }

    /**
     * 根据ID集合批量查询用户信息
     */
    public List<Role> findByIds(Collection<Long> ids) {
        StringBuilder sql = new StringBuilder("select * from auth_role where id in (");
        Object[] args = new Object[ids.size()];

        AtomicInteger index = new AtomicInteger(0);
        // JDK1.8 的 forEach 和 Lambda表达式
        ids.forEach((id) -> {
            sql.append(id).append("?,");
            args[index.getAndIncrement()] = id;
        });
        sql.deleteCharAt(sql.length() - 2);
        sql.append(")");

        return jdbcTemplate.query(sql.toString(), ids.toArray(new Object[0]), new RoleMapper());
    }

    /**
     * 将角色实体对象与行记录做映射关系
     */
    private class RoleMapper implements RowMapper<Role> {
        @Override
        public Role mapRow(ResultSet rs, int index) throws SQLException {
            Role role = new Role();
            role.setId(rs.getLong("id"));
            role.setName(rs.getString("name"));
            return role;
        }
    }
}
