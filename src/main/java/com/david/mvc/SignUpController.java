package com.david.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 注册控制器
 */
@Controller
public class SignUpController {

    @RequestMapping("/doSignup")
    public String doSignup(){
        return null;
    }
}
