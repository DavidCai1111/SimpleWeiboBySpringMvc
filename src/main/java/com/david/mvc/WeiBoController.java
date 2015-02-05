package com.david.mvc;

import com.david.dao.WeiboDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;

/**
 * 微博控制器
 */
@Controller
public class WeiBoController {
    WeiboDao weiboDao;
    HttpServletRequest request;

    @Autowired
    public WeiBoController(WeiboDao weiboDao, HttpServletRequest request) {
        this.weiboDao = weiboDao;
        this.request = request;
    }

    @RequestMapping({"/say"})
    public String sayAWeiBo(){
        weiboDao.SayOne(request.getParameter("userOfWeibo"),request.getParameter("contentOfWeibo"));
        return "redirect:/";
    }
}
