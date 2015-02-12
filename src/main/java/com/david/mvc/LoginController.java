package com.david.mvc;

import com.david.service.UserService;
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

    private UserService userService;
    private HttpServletRequest request;

    @Autowired
    public LoginController(UserService userService, HttpServletRequest request) {
        this.userService = userService;
        this.request = request;
    }

    @RequestMapping({"/login"})
    public String showLoginPage(){
        if(request.getSession().getAttribute("username") != null){
            return "redirect:/";
        }else {
            return "login";
        }
    }

    @RequestMapping({"/dologin"})
    public String doLogin(){
            String username = request.getParameter("username");
        String password = request.getParameter("password");
        boolean result = userService.checkUserInfoInForm(username, password);
        if(result){
            return "redirect:/";
        }else {
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
