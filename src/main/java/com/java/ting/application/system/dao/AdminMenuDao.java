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
    public List<AdminMenu> findParentList(AdminMenu adminMenu);
}
