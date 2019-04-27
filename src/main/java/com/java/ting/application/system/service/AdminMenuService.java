package com.java.ting.application.system.service;

import com.java.ting.application.system.dao.AdminMenuDao;
import com.java.ting.application.system.entity.AdminMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 后台菜单Service
 * @author  TingOu
 */
@Service
public class AdminMenuService {
    @Autowired
    AdminMenuDao dao;

    public List<AdminMenu> findParentList(AdminMenu adminMenu) {
        return dao.findParentList(adminMenu);
    }
}
