package com.java.ting;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;

/**
 * spring boot 启动类
 *
 * @author TingOu
 */
@SpringBootApplication
@ServletComponentScan
@EnableCaching
@MapperScan({"com.java.ting.dev.dao", "com.java.ting.application"})
public class TingApplication extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(TingApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(TingApplication.class, args);
    }
}
