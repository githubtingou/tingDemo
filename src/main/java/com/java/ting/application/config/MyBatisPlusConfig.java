package com.java.ting.application.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.java.ting.application.config.enums.ResponseVo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * mybatis-plus配置
 *
 * @author TingOu
 * @date 2019/2/27
 **/
@EnableTransactionManagement
@Configuration
public class MyBatisPlusConfig {
    /**
     * mybatis-plus分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

}
