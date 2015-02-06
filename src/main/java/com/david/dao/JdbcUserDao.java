package com.david.dao;

import com.david.model.User;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.lang.reflect.GenericArrayType;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 用户信息DAO层
 */
public class JdbcUserDao extends JdbcDaoSupport implements UserDao {

    public static final String CHECK_USER_INFO = "SELECT username FROM user WHERE username = ? AND password = ?";
    public static final String FIND_THE_USER = "SELECT id FROM user WHERE username = ?";
    public static final String ADD_ONE_USER = "INSERT INTO user (username,password) VALUES ( ? , ? )";
    public static final String GET_BY_USER_NAME = "SELECT id,username,password,role FROM user WHERE username = ?";
    public static final String LOAD_USER_ROLE_BY_NAME = "SELECT role FROM user WHERE username = ?";

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

    @Override
    public User getByUsername(String username) {
         User userGet = getJdbcTemplate().queryForObject(GET_BY_USER_NAME, new String[]{username}, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                User user = new User();
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setRole(resultSet.getString("role"));
                return user;
            }
        });
        return userGet;
    }

    @Override
    public Collection<GrantedAuthority> loadUserAuthorities(String username) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        User userGet = getJdbcTemplate().queryForObject(LOAD_USER_ROLE_BY_NAME, new String[]{username}, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                User user = new User();
                user.setRole(resultSet.getString("role"));
                return user;
            }
        });
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(userGet.getRole());
        authorities.add(grantedAuthority);
        return authorities;
    }

}
