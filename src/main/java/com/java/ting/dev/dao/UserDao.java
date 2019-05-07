package com.java.ting.dev.dao;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.java.ting.dev.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserDao {

    /**
     * 分页查询用户
     * @param page
     * @return
     */
    Page<User> PageUser(Page<User> page);

    /**
     * 根据用户名查询用户
     *
     * @param name
     * @return
     */
    User findUser(@Param(value = "name") String name);

    /**
     * 获取用户
     *
     * @param map
     * @return
     */
    List<User> findUserPage(Map<String, Object> map);

    /**
     * 插入用户数据
     *
     * @param user
     */
    void insert(User user);

}
