package com.magdiev.dao;

import com.magdiev.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public User findUserByUsername(String username) {
        String sql = "SELECT * FROM schema_web.users WHERE username = ?";

        return (User) jdbcTemplate.queryForObject(sql,
                new Object[]{username},
                BeanPropertyRowMapper.newInstance(User.class));
    }

    @Override
    public User findUserById(int id) {
        String sql = "SELECT * FROM schema_web.users WHERE id = ?";

        return (User) jdbcTemplate.queryForObject(sql,
                                                    new Object[]{id},
                                                    BeanPropertyRowMapper.newInstance(User.class));

    }

    @Override
    public void add(User user) {
        String sql = "INSERT INTO schema_web.users(username, password) VALUES (?,?)";
        jdbcTemplate.update(sql, user.getUsername(), user.getPassword());
    }
}
