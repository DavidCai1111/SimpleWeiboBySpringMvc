package com.david.restful;

import com.david.model.Weibo;
import com.david.service.WeiboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 处理Weibo相关RESTful请求
 */
public class WeiBoAbout {
    WeiboService weiboService;

    @Autowired
    public WeiBoAbout(WeiboService weiboService) {
        this.weiboService = weiboService;
    }

    @RequestMapping(value = "/weibo/{username}",method = RequestMethod.GET,headers = {"Accept=text/xml,application/json"})
    public @ResponseBody List<Weibo> getWeiboByUsername(@PathVariable String username){
        return weiboService.getWeiboByUsername(username);
    }
}
