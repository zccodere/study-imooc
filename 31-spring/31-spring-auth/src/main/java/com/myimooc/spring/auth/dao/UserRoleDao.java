package com.myimooc.spring.auth.dao;

import com.myimooc.spring.auth.common.BaseDao;
import com.myimooc.spring.auth.common.IdUtils;
import com.myimooc.spring.auth.entity.UserRole;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 用户角色Dao
 *
 * @author zc 2017-08-19
 */
@Repository
public class UserRoleDao extends BaseDao {

    /**
     * 保存用户角色对应关系
     */
    public void save(UserRole user) {
        user.setId(IdUtils.getDateTimeStr());
        String sql = "insert into auth_user_role(id,role_id,user_id) values(?,?,?)";
        jdbcTemplate.update(sql, user.getId(), user.getRoleId(), user.getUserId());
    }

    /**
     * 批量保存用户角色对应关系
     */
    public void saveAll(Collection<UserRole> userRoles) {
        String sql = "insert into auth_user_role(id,role_id,user_id) values(?,?,?)";
        List<Object[]> batchArgs = new ArrayList<>();
        userRoles.forEach((userRole) -> {
            Object[] objs = new Object[3];
            objs[0] = IdUtils.getDateTimeStr();
            objs[1] = userRole.getUserId();
            objs[2] = userRole.getRoleId();

            batchArgs.add(objs);
        });
        jdbcTemplate.batchUpdate(sql, batchArgs);
    }

    /**
     * 根据ID删除保存用户角色对应关系
     */
    public void deleteById(Long id) {
        String sql = "delete from auth_user_role where id = ?";
        jdbcTemplate.update(sql, id);
    }

    public void update(UserRole user) {
        String sql = "update auth_user_role set role_id = ?,user_id = ? where id = ?";
        jdbcTemplate.update(sql, user.getRoleId(), user.getUserId(), user.getId());
    }

    /**
     * 根据ID查询
     */
    public UserRole findById(Long id) {
        String sql = "select * from auth_user_role where id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new UserRoleMapper());
    }

    /**
     * 根据用户ID查询
     */
    public List<UserRole> findByUserId(Long userId) {
        String sql = "select * from auth_user_role where user_id = ?";
        return jdbcTemplate.query(sql, new Object[]{userId}, new UserRoleMapper());
    }

    /**
     * 分页查询
     *
     * @param page 页码，第n页
     * @param size 每页记录数
     * @return 行记录集合
     */
    public List<UserRole> findByPage(int page, int size) {
        if (page < 1) {
            page = 1;
        }
        if (size < 0) {
            size = 20;
        }
        String sql = "select * from auth_user_role limit ?,?";
        int skip = (page - 1) * size;
        return jdbcTemplate.query(sql, new Object[]{skip, size}, new UserRoleMapper());
    }

    /**
     * 将用户角色实体对象与行记录做映射关系
     */
    private class UserRoleMapper implements RowMapper<UserRole> {
        @Override
        public UserRole mapRow(ResultSet rs, int index) throws SQLException {
            UserRole user = new UserRole();
            user.setId(rs.getLong("id"));
            user.setUserId(rs.getLong("user_id"));
            user.setRoleId(rs.getLong("role_id"));
            return user;
        }
    }
}
