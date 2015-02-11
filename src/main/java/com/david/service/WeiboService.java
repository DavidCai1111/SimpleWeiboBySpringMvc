package com.david.service;

import com.david.dao.WeiboDao;
import com.david.model.Page;
import com.david.model.Weibo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Weibo相关业务层
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

    public List<Weibo> findWeiboByLimit(String index , String totalWeibos){
        int indexNeed;
        if((Integer.parseInt(totalWeibos) - Integer.parseInt(index) * 5) >= 0){
            indexNeed = Integer.parseInt(totalWeibos) - (Integer.parseInt(index) - 1) * 5 - Page.WEIBOS_SHOWN_PER_PAGE;
            System.out.println("indexNeed: " + indexNeed);
            return weiboDao.findWeiboByLimit(indexNeed + "",false);
        }else {
            indexNeed = Integer.parseInt(totalWeibos) - (Integer.parseInt(index)-1) * 5;
            System.out.println("indexNeed: " + indexNeed);
            return weiboDao.findWeiboByLimit(indexNeed + "",true);
        }
    }
}
