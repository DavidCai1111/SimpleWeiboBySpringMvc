package com.david.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * 主页控制器
 */
@Controller
public class HomeController {

    public HomeController() {
    }

    @RequestMapping({"/","/home"})
    public String showHomePage(Map<String,Object> model){
        System.out.println("inShowHomePage");
        return "home";
    }
}
