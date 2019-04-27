package com.java.ting.application.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

/**
 * 获取配置文件的参数
 *
 * @author TingOu
 */
public abstract class BaseController {
    /**
     * 日志对象
     */
    protected Logger logger = LoggerFactory.getLogger(getClass());
    /**
     * 后台管理路径
     */
    @Value("${adminPath}")
    public String adminPath;

    /**
     * 前台管理路径
     */
    @Value("${frontPath}")
    public String frontPath;


}
