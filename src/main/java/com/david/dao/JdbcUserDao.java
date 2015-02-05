package com.david.dao;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 用户信息DAO层
 */
public class JdbcUserDao extends JdbcDaoSupport implements UserDao {

    public static final String CHECK_USER_INFO = "SELECT username FROM user WHERE username = ? AND password = ?";

    @Override
    public boolean checkUserInfoInForm(String username,String password) {
        boolean result;

        try {
            getJdbcTemplate().queryForObject(CHECK_USER_INFO, new String[]{username, password}, new RowMapper<Boolean>() {
                @Override
                public Boolean mapRow(ResultSet resultSet, int i) throws SQLException {
                    return true;
                }
            });
            result = true;
        }catch (EmptyResultDataAccessException e){
            result = false;
        }

        return result;
    }

}
