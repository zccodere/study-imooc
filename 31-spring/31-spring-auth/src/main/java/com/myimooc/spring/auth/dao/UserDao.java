package com.myimooc.spring.auth.dao;

import com.myimooc.spring.auth.common.BaseDao;
import com.myimooc.spring.auth.entity.User;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 用户Dao
 *
 * @author zc 2017-08-19
 */
@Repository
public class UserDao extends BaseDao {

    /**
     * 根据用户名和密码查询用户
     */
    public User findByNameAndPwd(String name, String pwd) {
        String sql = "select * from auth_user where name = ? and pwd = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{name, pwd}, new UserMapper());
    }

    public void save(User user) {
        String sql = "insert into auth_user(id,name,pwd) values(?,?,?)";
        jdbcTemplate.update(sql, user.getId(), user.getName(), user.getPwd());
    }

    public void deleteById(Long id) {
        String sql = "delete from auth_user where id = ?";
        jdbcTemplate.update(sql, id);
    }

    public void update(User user) {
        String sql = "update auth_user set name = ?,pwd = ? where id = ?";
        jdbcTemplate.update(sql, user.getName(), user.getPwd(), user.getId());
    }

    public User findById(Long id) {
        String sql = "select * from auth_user where id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new UserMapper());
    }

    /**
     * 根据ID集合批量查询用户信息
     */
    public List<User> findByIds(Collection<Long> ids) {
        StringBuilder sql = new StringBuilder("select * from auth_user where id in (");
        Object[] args = new Object[ids.size()];

        AtomicInteger index = new AtomicInteger(0);
        // JDK1.8 的 forEach 和 Lambda表达式
        ids.forEach((id) -> {
            sql.append(id).append("?,");
            args[index.getAndIncrement()] = id;
        });
        sql.deleteCharAt(sql.length() - 2);
        sql.append(")");

        return jdbcTemplate.query(sql.toString(), ids.toArray(new Object[0]), new UserMapper());
    }

    /**
     * 分页查询
     *
     * @param page 页码，第n页
     * @param size 每页记录数
     * @return 行记录集合
     */
    public List<User> findByPage(int page, int size) {
        if (page < 1) {
            page = 1;
        }
        if (size < 0) {
            size = 20;
        }
        String sql = "select * from auth_user limit ?,?";
        int skip = (page - 1) * size;
        return jdbcTemplate.query(sql, new Object[]{skip, size}, new UserMapper());
    }

    /**
     * 将用户实体对象与行记录做映射关系
     */
    private class UserMapper implements RowMapper<User> {
        @Override
        public User mapRow(ResultSet rs, int index) throws SQLException {
            User user = new User();
            user.setId(rs.getLong("id"));
            user.setName(rs.getString("name"));
            user.setPwd(rs.getString("pwd"));
            return user;
        }
    }
}
