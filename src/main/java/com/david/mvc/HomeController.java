package com.david.mvc;

import com.david.dao.WeiboDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * 主页控制器
 */
@Controller
public class HomeController {
    private WeiboDao weiboDao;

    public HomeController() {
    }

    @Autowired
    public HomeController(WeiboDao weiboDao) {
        this.weiboDao = weiboDao;
    }

    @RequestMapping({"/","/home"})
    public String showHomePage(Map<String,Object> model){
        System.out.println("inShowHomePage");
        model.put("weibos",weiboDao.findAll());
        System.out.println(model.entrySet().size());
        return "home";
    }
}
