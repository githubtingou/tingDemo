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
     * @retrun
     */
    @RequestMapping("/companyInsert")
    @Scheduled(cron = "0 0 0 * * ?") // 每天24点执行
    public void insert() {
        //设置日期格式
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        log.debug("定时任务--执行插入数据");
        // 每次执行前先删除company表中的数据
        companyService.deleteAll();
        // 首次获取接口的总数
        String url = "http://218.75.3.252:8088/tzhbwf/dataDocking/selectUnit" +
                ".do?start=0&limit=1&username=tzhbwf_admin&password=pzl1.01!k4@1zs";
        com.java.ting.dev.controller.UserController userController = new com.java.ting.dev.controller.UserController();
        // 获取所有个数
        Object limit = JSONObject.fromObject(userController.getUrl(url)).get("total");
        // 第二次获取所有的接口数据
        String allData = "http://218.75.3.252:8088/tzhbwf/dataDocking/selectUnit" +
                ".do?start=0&limit=" + limit + "&username=tzhbwf_admin&password=pzl1.01!k4@1zs";
        JSONObject jsonObject = userController.getUrl(allData);
        JSONArray jsonArray = jsonObject.getJSONArray("rows");
        List<Company> rules = new ArrayList<Company>();

        // 如果数据为空return跳出方法
        if (jsonArray.size() <= 0) {
            return;
        }

        // 将JSONArray转为javaBean对象
        for (int i = 0; i < jsonArray.size(); i++) {
            // 将array中的数据进行逐条转换
            JSONObject object = (JSONObject) jsonArray.get(i);
            // 通过JSONObject.toBean()方法进行对象间的转换
            Company rule = (Company) JSONObject.toBean(object, Company.class);
            rules.add(rule);
        }

        // 批量插入
        companyService.insertAll(rules);

    }

}