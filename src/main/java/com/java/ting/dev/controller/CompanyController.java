package com.java.ting.dev.controller;

import com.java.ting.application.utils.BaseController;
import com.java.ting.dev.entity.Company;
import com.java.ting.dev.service.CompanyService;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * 定时插入公司信息表
 *
 * @author TingOU
 */
@Controller
@RequestMapping("/${adminPath}")
@EnableScheduling
@Slf4j
public class CompanyController extends BaseController {
    @Autowired
    CompanyService companyService;

    /**
     * 每天0:00将固废的公司数据插入数据库中
     *
     * @retrun
     */
    @RequestMapping("/companyInsert")
    @Scheduled(cron = "0 0 0 * * ?") // 每天24点执行
    public void insert() {

    }

}