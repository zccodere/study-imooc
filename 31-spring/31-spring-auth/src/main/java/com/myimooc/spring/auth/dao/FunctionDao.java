package com.myimooc.spring.auth.dao;

import com.myimooc.spring.auth.common.BaseDao;
import com.myimooc.spring.auth.common.IdUtils;
import com.myimooc.spring.auth.entity.Function;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 菜单功能Dao
 *
 * @author zc 2017-08-19
 */
@Repository
public class FunctionDao extends BaseDao {

    /**
     * 保存菜单功能
     */
    public void save(Function function) {
        function.setId(IdUtils.getDateTimeStr());
        String sql = "insert into auth_function(id,name,parent_id,url,serial_num,accordion) values(?,?,?,?,?,?)";
        jdbcTemplate.update(sql, function.getId(), function.getName(), function.getParentId(), function.getUrl(), function.getSerialNum(), function.getAccordion());
    }

    /**
     * 根据ID删除功能
     */
    public void deleteById(Long id) {
        String sql = "delete from auth_function where id = ?";
        jdbcTemplate.update(sql, id);
    }

    /**
     * 根据ID更新功能的URL
     */
    public void updateUrl(Long id, String url) {
        String sql = "update auth_function set url = ? where id = ?";
        jdbcTemplate.update(sql, url, id);
    }

    public void update(Function function) {
        String sql = "update auth_function set name = ?,parent_id = ? ,url = ?,serial_num = ?,accordion = ? where id = ?";
        jdbcTemplate.update(sql, function.getName(), function.getParentId(), function.getUrl(), function.getSerialNum(), function.getAccordion(), function.getId());
    }

    /**
     * 查询全部菜单功能
     */
    public List<Function> findAll() {
        String sql = "select * from auth_function";
        return jdbcTemplate.query(sql, new FunctionMapper());
    }

    public Function findById(Long id) {
        String sql = "select * from auth_function where id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new FunctionMapper());
    }

    /**
     * 根据ID集合批量查询
     */
    public Collection<Function> findByIds(Collection<Long> ids) {
        StringBuilder sql = new StringBuilder("select * from auth_function where id in (");
        Object[] args = new Object[ids.size()];

        AtomicInteger index = new AtomicInteger(0);
        // JDK1.8 的 forEach 和 Lambda表达式
        ids.forEach((id) -> {
            sql.append(id).append("?,");
            args[index.getAndIncrement()] = id;
        });
        sql.deleteCharAt(sql.length() - 2);
        sql.append(")");

        return jdbcTemplate.query(sql.toString(), ids.toArray(new Object[0]), new FunctionMapper());
    }

    /**
     * 分页查询（根据父节点）
     *
     * @param page 页码，第n页
     * @param size 每页记录数
     * @return 行记录集合
     */
    public List<Function> findByPage(int page, int size, long parentId) {
        if (page < 1) {
            page = 1;
        }
        if (size < 0) {
            size = 20;
        }
        String sql = "select * from auth_function where parent_id = ? limit ?,?";
        int skip = (page - 1) * size;
        return jdbcTemplate.query(sql, new Object[]{parentId, skip, size}, new FunctionMapper());
    }

    /**
     * 将菜单功能实体对象与行记录做映射关系
     */
    private class FunctionMapper implements RowMapper<Function> {
        @Override
        public Function mapRow(ResultSet rs, int index) throws SQLException {
            Function function = new Function();
            function.setId(rs.getLong("id"));
            function.setName(rs.getString("name"));
            function.setParentId(rs.getLong("parent_id"));
            function.setUrl(rs.getString("url"));
            function.setSerialNum(rs.getInt("serial_num"));
            function.setAccordion(rs.getInt("accordion"));
            return function;
        }
    }
}
