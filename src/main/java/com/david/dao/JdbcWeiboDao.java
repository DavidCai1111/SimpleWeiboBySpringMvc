package com.david.dao;

import com.david.model.Weibo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 微博信息数据库DAO层
 */
public class JdbcWeiboDao extends JdbcDaoSupport implements WeiboDao {
    private static final String FIND_ALL_WEIBO = "SELECT name,content FROM weibo";
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

    public static void main(String[] args) {
        ApplicationContext context = new FileSystemXmlApplicationContext("F:\\maven\\JustSimpleWeiBo\\src\\main\\java\\spring-config.xml");
        WeiboDao weiboDao = (WeiboDao) context.getBean("WeiBoDao");
        List<Weibo> listGet = new ArrayList<Weibo>();
        listGet =   weiboDao.findAll();
        for (Weibo weibo : listGet){
            System.out.println(weibo.getName());
            System.out.println(weibo.getContent());
            System.out.println("-------------------------");
        }
    }

}
