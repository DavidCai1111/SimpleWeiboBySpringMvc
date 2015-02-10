package com.david.dao;

import com.david.model.Page;
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

    private static final String FIND_ALL_WEIBO = "SELECT id,name,content FROM weibo";
    public static final String SAY_ONE = "INSERT INTO weibo (name,content) VALUES ( ? , ? )";
    public static final String DELETE_ONE = "DELETE FROM weibo WHERE id = ?";
    public static final String GET_WEIBO_BY_USERNAME= "SELECT id,name,content FROM weibo WHERE name = ?";
    public static final String FIND_WEIBOS_BY_LIMIT = "SELECT id,name,content FROM weibo LIMIT ? , ?";

    @Override
    public List<Weibo> findAll() {
        List<Weibo> listGet = new ArrayList<Weibo>();
        listGet = getJdbcTemplate().query(FIND_ALL_WEIBO,new RowMapper<Weibo>() {
            @Override
            public Weibo mapRow(ResultSet resultSet, int i) throws SQLException {
                Weibo weibo = new Weibo();
                weibo.setId(resultSet.getInt("id"));
                weibo.setName(resultSet.getString("name"));
                weibo.setContent(resultSet.getString("content"));
                return weibo;
            }
        });
        return listGet;
    }

    @Override
    public void SayOne(String user,String content) {
        getJdbcTemplate().update(SAY_ONE, new String[]{user, content});
    }

    @Override
    public void deleteOne(String id) {
        getJdbcTemplate().update(DELETE_ONE,new String[]{id});
    }

    @Override
    public List<Weibo> getWeiboByUsername(String username) {
        List<Weibo> listGet = new ArrayList<Weibo>();
        listGet = getJdbcTemplate().query(GET_WEIBO_BY_USERNAME, new String[]{username}, new RowMapper<Weibo>() {
            @Override
            public Weibo mapRow(ResultSet resultSet, int i) throws SQLException {
                Weibo weibo = new Weibo();
                weibo.setId(resultSet.getInt("id"));
                weibo.setName(resultSet.getString("name"));
                weibo.setContent(resultSet.getString("content"));
                return weibo;
            }
        });
        return listGet;
    }

    @Override
    public List<Weibo> findWeiboByLimit(String index) {
        if(Integer.parseInt(index) <= 0){
            index = "1";
        }
        return getJdbcTemplate().query(FIND_WEIBOS_BY_LIMIT, new Integer[]{Integer.parseInt(index), Page.WEIBOS_SHOWN_PER_PAGE}, new RowMapper<Weibo>() {
            @Override
            public Weibo mapRow(ResultSet resultSet, int i) throws SQLException {
                Weibo weibo = new Weibo();
                weibo.setId(resultSet.getInt("id"));
                weibo.setName(resultSet.getString("name"));
                weibo.setContent(resultSet.getString("content"));
                return weibo;
            }
        });
    }

}
