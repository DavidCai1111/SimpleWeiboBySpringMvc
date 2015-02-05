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
    public static final String FIND_THE_USER = "SELECT id FROM user WHERE username = ?";
    public static final String ADD_ONE_USER = "INSERT INTO user (username,password) VALUES ( ? , ? )";

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

    @Override
    public boolean FindTheUser(String username) {
        boolean result;
        try {
            getJdbcTemplate().queryForObject(FIND_THE_USER, new String[]{username}, new RowMapper<Boolean>() {
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

    @Override
    public void AddOneUser(String username, String password) {
        getJdbcTemplate().update(ADD_ONE_USER,new String[]{username,password});
    }

}
