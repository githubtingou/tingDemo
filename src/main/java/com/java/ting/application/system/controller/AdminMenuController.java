package com.java.ting.application.system.controller;

import com.java.ting.application.utils.BaseController;
import com.java.ting.application.system.entity.AdminMenu;
import com.java.ting.application.system.service.AdminMenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 后台菜单Controller
 *
 * @author TingOu
 */
@Controller
@RequestMapping(value = "${frontPath}")
@Slf4j
public class AdminMenuController extends BaseController {
    @Autowired
    private AdminMenuService adminMenuService;

    @RequestMapping(value = "adminMenu")
    @ResponseBody
    public List adminMenuList(AdminMenu adminMenu) {
        return adminMenuService.findParentList(adminMenu);
    }
}
