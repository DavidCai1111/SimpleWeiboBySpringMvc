package com.david.mvc;

import com.david.model.User;
import com.david.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

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
            request.getSession().setAttribute("signUpSucceed",true);
            return "redirect:/login";
        }

    }

    @RequestMapping(value = "/signUp/validate",method = RequestMethod.POST,consumes = "application/json")
    public @ResponseBody Map<String,Boolean> validate(@RequestBody User user){
        boolean result = userService.findTheUser(user.getUsername());
        Map<String,Boolean> map = new HashMap<String, Boolean>();
        map.put("result",result);
        return map;
    }
}
