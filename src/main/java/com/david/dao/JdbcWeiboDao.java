package com.david.dao;

import com.david.model.Weibo;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import javax.servlet.http.HttpServletRequest;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 微博信息数据库DAO层
 */
public class JdbcWeiboDao extends JdbcDaoSupport implements WeiboDao {

    private static final String FIND_ALL_WEIBO = "SELECT name,content FROM weibo";
    public static final String SAY_ONE = "INSERT INTO weibo (name,content) VALUES (? , ?)";

    @Override
    public List<Weibo> findAll() {
        List<Weibo> listGet = new ArrayList<Weibo>();
        listGet = getJdbcTemplate().query(FIND_ALL_WEIBO,new RowMapper<Weibo>() {
            @Override
            public Weibo mapRow(ResultSet resultSet, int i) throws SQLException {
                Weibo weibo = new Weibo();
                weibo.setName(resultSet.getString("name"));
                weibo.setContent(resultSet.getString("content"));
                return weibo;
            }
        });
        return listGet;
    }

    @Override
    public void SayOne(String user,String content) {
        getJdbcTemplate().update(SAY_ONE,new String[]{user,content});
    }

}
