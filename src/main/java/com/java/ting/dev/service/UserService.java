package com.java.ting.dev.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.java.ting.application.utils.UUIDUtil;
import com.java.ting.dev.dao.UserDao;
import com.java.ting.dev.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * 用户 service
 *
 * @author TingOu
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class UserService {

    @Autowired
    private UserDao userDao;

    @Cacheable(cacheNames = "user.name", key = "#name")
    public User findUser(String name) {
        User user = userDao.findUser(name);
        return user;
    }

    public List<User> findUserPage(Map<String, Object> map) {
        return userDao.findUserPage(map);
    }

    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public void insert(User user) {
        // 密码加密
        user.setId(UUIDUtil.getUUID());
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword().trim()));
        userDao.insert(user);
    }

    /**
     * 分页
     *
     * @return
     */
    public Page<User> findList(Page<User> page) {
        return userDao.PageUser(page);
    }

}
