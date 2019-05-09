package com.java.ting.test;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.java.ting.dev.entity.User;
import com.java.ting.dev.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class TestController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/hello")
    public String hello(Model map) {
        map.addAttribute("index", "success");
        return "index";
    }

    @RequestMapping(value = "/front/userPage")
    @ResponseBody
    public Object userPage() {
        Page<User> page = new Page<User>(1, 5);
        Page<User> list = userService.findList(page);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("total", list.getTotal());
        map.put("rows", list.getRecords().toArray());
        return map;
    }

}
