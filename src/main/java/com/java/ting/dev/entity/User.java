package com.java.ting.dev.entity;


import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @author TingOu
 */
public class User {
    private String id;
    private String name;
    private Integer age;
    private String password;
    private String status;

    public User() {
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public Integer getAge() {
        return this.age;
    }

    public String getPassword() {
        return this.password;
    }

    public String getStatus() {
        return this.status;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
