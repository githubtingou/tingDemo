package com.java.ting.application.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 页面跳转管理
 *
 * @author Tingou
 */
@Controller
public class LoginController {
    /**
     * 调转到后台登录页
     *
     * @return
     */
    @RequestMapping(value = {"/login", "/"})
    public String login() {
        return "login";
    }
}
