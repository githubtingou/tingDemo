package com.java.ting.application.utils;

/**
 * uuid工具类
 *
 * @author TingOu
 */
public class UUIDUtil {
    /**
     * 封装JDK自带的UUID, 通过Random数字生成, 中间无-分割.
     */
    public static String getUUID() {
        return java.util.UUID.randomUUID().toString().replaceAll("-", "");
    }
}