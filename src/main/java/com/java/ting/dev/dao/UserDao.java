package com.java.ting.dev.dao;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.java.ting.dev.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

@Mapper
public interface UserDao {

    Page<User> findList(Page<User> page);

    User findUser(@Param(value = "name") String name);

    // 获取用户
    List<User> findUserPage(Map<String, Object> map);

    void insert(User user);

}
