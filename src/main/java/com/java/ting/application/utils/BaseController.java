package com.java.ting.application.utils;

import lombok.extern.slf4j.Slf4j;
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
