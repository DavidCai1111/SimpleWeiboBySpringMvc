package com.david.mvc;

import com.david.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * 注册控制器
 */
@Controller
public class SignUpController {
    HttpServletRequest request;
    UserDao userDao;

    @Autowired
    public SignUpController(HttpServletRequest request, UserDao userDao) {
        this.request = request;
        this.userDao = userDao;
    }

    @RequestMapping("/signUp")
    public String showSignupPage(){

        if(request.getSession().getAttribute("username") != null){
            return "redirect:/";
        }else {
            return "signup";
        }

    }

    @RequestMapping("/doSignup")
    public String doSignup(){

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        boolean isSigned = userDao.FindTheUser(username);

        if(isSigned == true){
            return "redirect:/signUp";
        }else {
            userDao.AddOneUser(username,password);
            request.getSession().setAttribute("username",username);
            return "redirect:/";
        }

    }
}
