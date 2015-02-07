package com.david.service;

import com.david.dao.WeiboDao;
import com.david.model.Weibo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by caiwei on 2015/2/7.
 */
@Service
public class WeiboService {
    private WeiboDao weiboDao;

    @Autowired
    public WeiboService(WeiboDao weiboDao) {
        this.weiboDao = weiboDao;
    }

    public List<Weibo> getWeiboByUsername(String username){
        List<Weibo> listGet = weiboDao.getWeiboByUsername(username);
        return listGet;
    }

    public void sayOne(String user , String content){
        weiboDao.SayOne(user,content);
    }

    public void delete(String id){
        weiboDao.deleteOne(id);
    }

    public List<Weibo> findAll(){
        return weiboDao.findAll();
    }
}
