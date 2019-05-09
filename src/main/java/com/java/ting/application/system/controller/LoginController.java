package com.java.ting.application.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
    /**
     * 调转到首页
     *
     * @return
     */
    @RequestMapping(value = {"/login", "/"})
    public String login() {
        return "login";
    }
}
