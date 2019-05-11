package com.java.ting.dev.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * 用户实体类
 *
 * @author TingOu
 */
@Getter
@Setter
public class User {
    private String id;
    private String name;
    private Integer age;
    private String password;
    private String status;

}
