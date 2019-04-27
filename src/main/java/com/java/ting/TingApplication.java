package com.java.ting;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({"com.java.ting.dev.dao","com.java.ting.application.system.dao"})
public class TingApplication {

    public static void main(String[] args) {
        SpringApplication.run(TingApplication.class, args);
    }
}
