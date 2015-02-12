package com.david.mvc;

import com.david.model.Page;
import com.david.model.Weibo;
import com.david.service.WeiboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * 主页控制器
 */
@Controller
public class HomeController {
    private WeiboService weiboService;
    private HttpServletRequest request;

    @Autowired
    public HomeController(WeiboService weiboService, HttpServletRequest request) {
        this.weiboService = weiboService;
        this.request = request;
    }

    @RequestMapping({"/"})
    public String showHomePage(Map<String,Object> model){
        List<Weibo> listGet;
        HttpSession session = request.getSession();
        Page page = new Page();
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = userDetails.getUsername();
        session.setAttribute("username",username);
        if(session.getAttribute("pageTo") == null || "".equals(session.getAttribute("pageTo"))){
            //设置总页数
            listGet = weiboService.findAll();
            int totalPage;
            if(listGet.size() % Page.WEIBOS_SHOWN_PER_PAGE == 0){
                totalPage = listGet.size() / Page.WEIBOS_SHOWN_PER_PAGE;
            }else {
                totalPage = listGet.size() / Page.WEIBOS_SHOWN_PER_PAGE + 1;
            }
            //设置默认page
            page.setTotalPage(totalPage);
            page.setPageNow(1);
            page.setTotalWeibos(listGet.size());
        }else {
            System.out.println("pageTo: " + session.getAttribute("pageTo").toString());
            listGet = weiboService.findWeiboByLimit(session.getAttribute("pageTo").toString(),session.getAttribute("TotalWeibos").toString());
            //设置page
            page.setTotalPage(Integer.parseInt(session.getAttribute("pageTotal").toString()));
            System.out.println("pageTotal: " + session.getAttribute("pageTotal").toString());
            page.setPageNow(Integer.parseInt(session.getAttribute("pageTo").toString()));
            page.setTotalWeibos(Integer.parseInt(session.getAttribute("TotalWeibos").toString()));
        }
        //设置微博分页
        Collections.reverse(listGet);
        if(listGet.size() > Page.WEIBOS_SHOWN_PER_PAGE){
            for(int i = (listGet.size() - 1) ; i > (Page.WEIBOS_SHOWN_PER_PAGE - 1) ; i -- ){
                listGet.remove(i);
            }
        }
        //存放session
        session.setAttribute("pageTotal",page.getTotalPage());
        session.setAttribute("pageNow",page.getPageNow());
        session.setAttribute("TotalWeibos",page.getTotalWeibos());
        //存放数据模型
        model.put("weibos",listGet);
        model.put("page",page);
        return "home";
    }

    @RequestMapping({"/home/{pageTo}"})
    public String showHomePageByLimit(@PathVariable String pageTo){
        System.out.println("pageTo in showHomePageByLimit() : " + pageTo);
        request.getSession().setAttribute("pageTo",pageTo);
        return "redirect:/";
    }

}
