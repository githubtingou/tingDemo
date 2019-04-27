package com.java.ting;

import com.java.ting.application.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.ForwardAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.RememberMeServices;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;

import static org.springframework.security.config.Elements.REMEMBER_ME;

/**
 * Spring Security 拦截器
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Value("${adminPath}")
    public String adminPath;
    @Value("${frontPath}")
    public String frontPath;

    @Bean
    UserDetailsService customUserService() {
        // 注册UserDetailsService 的bean
        return new SecurityService();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                // 允许访问的路径
                .antMatchers("/", "/find/**", "/dev/**", "/" + frontPath + "/**").permitAll()
                // 其他所有资源都需要登陆后才能访问
                .anyRequest().authenticated()
                // 设置默认登陆页面/login
                .and().formLogin().loginPage("/login").usernameParameter("username")
                .passwordParameter("password").failureUrl("/login?error=true")
                .successHandler(new ForwardAuthenticationSuccessHandler("/" + adminPath + "/index"))// 指定登陆成功后跳转的路径
                .permitAll() // 登录页面用户任意访问
                .and().headers().defaultsDisabled().cacheControl()// 解决用户安全退出后点击返回仍进入需验证的页面
                .and().frameOptions().sameOrigin().and()// 跨域问题
                .logout().logoutUrl("/loginOut").logoutSuccessUrl("/login")
                .deleteCookies("JSESSIONID").invalidateHttpSession(true)//删除当前的JSESSIONID
                .permitAll()
                .and()
                .csrf().disable() // 关闭csrf认证
                .rememberMe()
                .and().sessionManagement().maximumSessions(1).expiredUrl("/login"); //控制单个用户只能创建一个session，也就只能在服务器登录一次
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        //不拦截静态资源
        web.ignoring().antMatchers("/static/**");
        super.configure(web);
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    /**
     * BCrypt加密password
     *
     * @return
     */
    @Bean
    public static PasswordEncoder bCryptEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * Spring secuirty 配置
     *
     * @return
     */
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setHideUserNotFoundExceptions(false); // 显示UserNotFoundExceptions
        provider.setUserDetailsService(customUserService());
        provider.setPasswordEncoder(bCryptEncoder());// 密码加密
        return provider;
    }
//    @Bean
//    public RememberMeServices rememberMeServices() {
//        JdbcTokenRepositoryImpl rememberMeTokenRepository = new JdbcTokenRepositoryImpl();
//        rememberMeTokenRepository.setDataSource(dataSource);
//
//        // 这里也注入了 UserDetailsSerice 实例
//        PersistentTokenBasedRememberMeServices rememberMeServices =
//                new PersistentTokenBasedRememberMeServices(INTERNAL_SECRET_KEY, userDetailsService,
// rememberMeTokenRepository);
//
//        rememberMeServices.setParameter(REMEMBER_ME);
//        return rememberMeServices;
//    }

}
