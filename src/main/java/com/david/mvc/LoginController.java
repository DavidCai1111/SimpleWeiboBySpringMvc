package com.david.mvc;

import com.david.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 注册页控制器
 */
@Controller
public class LoginController {

    private UserDao userDao;
    private HttpServletRequest request;

    @Autowired
    public LoginController(UserDao userDao, HttpServletRequest request) {
        this.userDao = userDao;
        this.request = request;
    }

    @RequestMapping({"/login"})
    public String showLoginPage(){
        return "login";
    }

    @RequestMapping({"/dologin"})
    public String doLogin(){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();
        boolean result = userDao.checkUserInfoInForm(username,password);
        System.out.println("result：" + result);
        if(result == true){
            System.out.println("登录成功");
            session.setAttribute("username",username);
            return "redirect:/";
        }else {
            System.out.println("登录失败");
            return "redirect:/login";
        }
    }

    @RequestMapping({"/logout"})
    public String doLogout(){
        HttpSession session = request.getSession();
        session.removeAttribute("username");
        return "redirect:/";
    }

}
