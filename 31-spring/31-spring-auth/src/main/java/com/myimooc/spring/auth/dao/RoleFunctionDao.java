package com.myimooc.spring.auth.dao;

import com.myimooc.spring.auth.common.BaseDao;
import com.myimooc.spring.auth.common.IdUtils;
import com.myimooc.spring.auth.entity.RoleFunction;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 角色菜单功能Dao
 *
 * @author zc 2017-08-19
 */
@Repository
public class RoleFunctionDao extends BaseDao {

    public void save(RoleFunction roleFunction) {
        String sql = "insert into auth_role_function(id,role_id,function_id,status) values(?,?,?,?)";
        jdbcTemplate.update(sql, roleFunction.getId(), roleFunction.getRoleId(), roleFunction.getFunctionId(), roleFunction.getStatus());
    }

    /**
     * 批量保存角色功能对应关系
     */
    public void saveAll(Collection<RoleFunction> roleFunctions) {
        String sql = "insert into auth_role_function(id,role_id,function_id,status) values(?,?,?,?)";
        List<Object[]> batchArgs = new ArrayList<>();
        roleFunctions.forEach((rf) -> {
            Object[] objs = new Object[3];
            objs[0] = IdUtils.getDateTimeStr();
            objs[1] = rf.getRoleId();
            objs[2] = rf.getFunctionId();
            objs[3] = rf.getStatus();

            batchArgs.add(objs);
        });
        jdbcTemplate.batchUpdate(sql, batchArgs);
    }

    /**
     * 根据角色ID删除角色功能对应关系
     */
    public void deleteByRoleId(Long roleId) {
        String sql = "delete from auth_role_function where role_id = ?";
        jdbcTemplate.update(sql, roleId);
    }

    public void update(RoleFunction roleFunction) {
        String sql = "update auth_role_function set role_id = ?,function_id = ?,status=? where id = ?";
        jdbcTemplate.update(sql, roleFunction.getRoleId(), roleFunction.getFunctionId(), roleFunction.getStatus(), roleFunction.getId());
    }

    /**
     * 根据ID查询角色功能对应关系
     */
    public RoleFunction findById(Long id) {
        String sql = "select * from auth_role_function where id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new RoleFunctionMapper());
    }

    /**
     * 根据角色ID查询角色功能对应关系
     */
    public List<RoleFunction> findByRoleId(Long roleId) {
        String sql = "select * from auth_role_function where role_id = ?";
        return jdbcTemplate.query(sql, new Object[]{roleId}, new RoleFunctionMapper());
    }

    /**
     * 分页查询
     *
     * @param page 页码，第n页
     * @param size 每页记录数
     * @return 行记录集合
     */
    public Collection<RoleFunction> findByPage(int page, int size) {
        if (page < 1) {
            page = 1;
        }
        if (size < 0) {
            size = 20;
        }
        String sql = "select * from auth_role_function limit ?,?";
        int skip = (page - 1) * size;
        return jdbcTemplate.query(sql, new Object[]{skip, size}, new RoleFunctionMapper());
    }

    /**
     * 将用户菜单功能实体对象与行记录做映射关系
     */
    private class RoleFunctionMapper implements RowMapper<RoleFunction> {
        @Override
        public RoleFunction mapRow(ResultSet rs, int index) throws SQLException {
            RoleFunction roleFunction = new RoleFunction();
            roleFunction.setId(rs.getLong("id"));
            roleFunction.setRoleId(rs.getLong("role_id"));
            roleFunction.setFunctionId(rs.getLong("function_id"));
            roleFunction.setStatus(rs.getInt("status"));
            return roleFunction;
        }
    }

}
