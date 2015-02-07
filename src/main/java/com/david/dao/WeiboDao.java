package com.david.dao;

import com.david.model.Weibo;

import java.util.List;

/**
 * Created by caiwei on 2015/2/5.
 */
public interface WeiboDao {
    public List<Weibo> findAll();
    public void SayOne(String user,String content);
    public void deleteOne(String id);
    public List<Weibo> getWeiboByUsername(String username);
}
