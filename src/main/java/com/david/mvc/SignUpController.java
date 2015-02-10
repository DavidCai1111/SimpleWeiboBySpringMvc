package com.david.mvc;

import com.david.service.UserService;
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
    UserService userService;

    @Autowired
    public SignUpController(HttpServletRequest request, UserService userService) {
        this.request = request;
        this.userService = userService;
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

        boolean isSigned = userService.findTheUser(username);

        if(isSigned){
            return "redirect:/signUp";
        }else {
            userService.addOneUser(username,password);
            request.getSession().setAttribute("username",username);
            return "redirect:/";
        }

    }
}
