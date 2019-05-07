package com.java.ting.application.system.dao;

import com.java.ting.application.system.entity.AdminMenu;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 后台菜单Dao
 */
@Mapper
@Transactional(readOnly = true)
public interface AdminMenuDao {
    /**
     * 查询菜单
     *
     * @param adminMenu
     * @return
     */
    List<AdminMenu> findParentList(AdminMenu adminMenu);
}
