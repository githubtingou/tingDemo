package com.java.ting.application;

import com.java.ting.dev.entity.User;
import com.java.ting.dev.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * 实现UserDetailsService接口 进行用户名密码的验证和用户的授权
 * @author TingOu
 */
public class SecurityService implements UserDetailsService {
    @Autowired
    HttpServletRequest request;
    @Autowired
    UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        logger.info("用户的用户名: {}", name);
        User user = userService.findUser(name);
        if (user == null) {
            throw new UsernameNotFoundException("用户名不正确!");
        }
        if (!passwordEncoder.matches(request.getParameter("password"), user.getPassword())) {
            throw new UsernameNotFoundException("密码错误!");
        }
        HttpSession session = request.getSession();
        session.setAttribute("user", user);
        session.setAttribute("username", name);
        List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
//        for (Role role:user.getRoles()) {
//            authorities.add(new SimpleGrantedAuthority(role.getName()));
//        }
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        // 这里返回登录名，密码和用户权限
        return new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(), authorities);
    }
}
