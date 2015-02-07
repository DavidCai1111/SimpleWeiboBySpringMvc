package com.david.mvc;

import com.david.dao.WeiboDao;
import com.david.service.WeiboService;
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
    private WeiboService weiboService;

    @Autowired
    public HomeController(WeiboService weiboService) {
        this.weiboService = weiboService;
    }

    @RequestMapping({"/","/home"})
    public String showHomePage(Map<String,Object> model){
        model.put("weibos",weiboService.findAll());
        return "home";
    }

}
