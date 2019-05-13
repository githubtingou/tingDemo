package com.java.ting.dev.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 用户实体类
 *
 * @author TingOu
 */
@Getter
@Setter
public class User implements Serializable {
    private static final long serialVersionUID = 3741049763289589977L;
    private String id;
    private String name;
    private Integer age;
    private String password;
    private String status;

}
