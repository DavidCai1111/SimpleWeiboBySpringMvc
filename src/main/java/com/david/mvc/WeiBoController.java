package com.david.mvc;

import com.david.dao.WeiboDao;
import com.david.service.WeiboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * 微博控制器
 */
@Controller
public class WeiBoController {
    HttpServletRequest request;
    WeiboService weiboService;

    @Autowired
    public WeiBoController(HttpServletRequest request, WeiboService weiboService) {
        this.request = request;
        this.weiboService = weiboService;
    }

    @RequestMapping({"/say"})
    public String sayAWeiBo(){
        weiboService.sayOne(request.getParameter("userOfWeibo"), request.getParameter("contentOfWeibo"));
        return "redirect:/";
    }

    @RequestMapping(value = {"/delete"},method = RequestMethod.DELETE)
    public String deleteOneWeiBo(){
        weiboService.delete(request.getParameter("idForDelete"));
        return "redirect:/";
    }
}
