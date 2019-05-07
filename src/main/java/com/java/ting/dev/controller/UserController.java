package com.java.ting.dev.controller;

import com.java.ting.application.utils.BaseController;
import com.java.ting.dev.entity.User;
import com.java.ting.dev.service.UserService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户管理Controller
 *
 * @author TingOu
 */
@Controller
public class UserController extends BaseController {

    @Autowired
    private UserService userService;
    @Autowired
    private Environment env;

    /**
     * 调转到首页
     *
     * @return
     */
    @RequestMapping(value = "login")
    public String login(HttpServletRequest response, HttpServletRequest request, HttpSession session) {
        return "login";
    }

    /**
     * 跳转到后台首页
     *
     * @return
     */
    @RequestMapping("/${adminPath}/index")
    public String adminIndex(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        return "admin/adminIndex";
    }

    /**
     * 跳转到用户管理页面
     *
     * @return
     */
    @RequestMapping("/find/userIndex")
    public String userIndex() {
        return "hello";
    }

    /**
     * 插入用户管理页面
     *
     * @return
     */
    @RequestMapping("/find/user")
    public String userInsert(User user) {
        userService.insert(user);
        return "redirect:/login";
    }

    /**
     * 跳转到联单信息页面
     *
     * @return
     */
    @RequestMapping("/find/couplet")
    public String frontCouplet(HttpServletRequest request) {
        return "front/index";
    }

    /**
     * 跳转到公司查询页面
     *
     * @return
     */
    @RequestMapping("/${adminPath}/company")
    public String frontCompany() {
        return "front/company";
    }

    /**
     * 获取联单信息
     *
     * @param start     开始条数
     * @param limit     分页个数
     * @param punitName 产生单位名称
     * @param hunitName 处置单位名称
     * @param applyCode 联单编号
     * @param planType  转移类型
     * @return 查询联单信息的接口
     */
    @RequestMapping("/dev/index")
    @ResponseBody
    public JSONObject getCouplet(@RequestParam(value = "offset", defaultValue = "0") String start,
                                 @RequestParam(value = "pageSize", defaultValue = "10") String limit,
                                 @RequestParam(value = "punitName") String punitName,
                                 @RequestParam(value = "hunitName") String hunitName,
                                 @RequestParam(value = "applyCode") String applyCode,
                                 @RequestParam(value = "planType") String planType) {
        String url = "http://218.75.3.252:8088/tzhbwf/dataDocking/selectReceipt.do?start=" + start + "&limit=" + limit +
                "&username=tzhbwf_admin&password=pzl1.01!k4@1zs" + "&punitName=" + punitName + "&hunitName=" +
                hunitName + "&applyCode=" + applyCode + "&planType=" + planType;
        return getUrl(url);
    }

    /**
     * 获取公司信息
     *
     * @param start    开始条数
     * @param limit    分页个数
     * @param unitName 企业名称
     * @param unitCode 组织机构代码
     * @return 查询公司信息的接口
     */
    @RequestMapping("/dev/company")
    @ResponseBody
    public JSONObject getCompany(@RequestParam(value = "offset", defaultValue = "0") String start,
                                 @RequestParam(value = "pageSize", defaultValue = "10") String limit,
                                 @RequestParam(value = "unitName") String unitName,
                                 @RequestParam(value = "unitCode") String unitCode) {
        String url = "http://218.75.3.252:8088/tzhbwf/dataDocking/selectUnit.do?start=" + start + "&limit=" + limit +
                "&username=tzhbwf_admin&password=pzl1.01!k4@1zs" + "&unitName=" + unitName + "&unitCode=" + unitCode;

        return getUrl(url);
    }

    /**
     * 根据url返回json数据
     *
     * @param url 接口路径
     * @return json数据
     */
    @ResponseBody
    public JSONObject getUrl(String url) {
        System.out.println(url);
        String res = "";
        try {
            URL urls = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) urls.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("GET");
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    conn.getInputStream(), "UTF-8"));
            String line;
            while ((line = in.readLine()) != null) {
                res += line;
            }
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        JSONObject result = new JSONObject();
        /**
         *  json 格式{"success":data,"root":data,"totalProperty":data}
         *  success:状态;root:所有数据;totalProperty:总数
         */
        try {
            JSONObject jsonObject = JSONObject.fromObject(res);
            // 获取存放在root中的所有数据
            JSONArray jsonArray = jsonObject.getJSONArray("root");
            //存放数据数量
            result.put("total", jsonObject.get("totalProperty"));
            //存放所有数据
            result.put("rows", jsonArray);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return result;
    }
    
    /**
     * 用户信息
     *
     * @param pageSize 每页显示的记录数
     * @param offset   开始条数
     * @param request
     * @return
     */
    @RequestMapping(value = "/findListJson")
    @ResponseBody
    public JSONObject findListJson(@RequestParam(value = "pageSize", defaultValue = "${pageSize}") Integer pageSize,
                                   @RequestParam(value = "offset", defaultValue = "0") Integer offset,
                                   HttpServletRequest request) {
        Map<String, Object> map = new HashMap<String, Object>();
        String name = request.getParameter("name");
        if (name != null && !"".equals(name)) {
            map.put("name", name);
        }
        /**
         *  分页;传到bootstrap-table的数据必须有total和rows参数
         */
        // 开始条数
        map.put("offset", offset);
        // 每页展示的个数
        map.put("pageSize", pageSize);
        List<User> list = userService.findUserPage(map);
        JSONObject result = new JSONObject();
        //存放数据数量
        result.put("total", userService.findUserPage(null).size());
        //存放所有数据
        result.put("rows", list);
        return result;
    }

    /**
     * eChartDemo页面
     *
     * @return 跳转到eChartsDemo.html页面
     */
    @RequestMapping(value = "/${frontPath}/eChartsDemoShow")
    public String eChartsDemoShow() {
        return "front/eChartsDemo";
    }

    /**
     * 获取eChart数据
     *
     * @return map数据
     */
    @RequestMapping(value = "/front/eChartsDemo")
    @ResponseBody
    public Map<Object, Object> eChartsDemo() {
        List<Object> listName = new ArrayList<Object>();
        listName.add("香蕉");
        listName.add("苹果");
        listName.add("橘子");
        listName.add("梨");
        listName.add("菠萝");
        List<Object> listData = new ArrayList<Object>();
        listData.add("20");
        listData.add("30");
        listData.add("40");
        listData.add("50");
        listData.add("60");
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("name", listName);
        map.put("data", listData);
        return map;
    }

    /**
     * 跳转到zTreeDemo页面
     *
     * @return ztreeDemo.html页面
     */
    @RequestMapping(value = "/${frontPath}/ztreeDemo")
    public String ztreeDemo() {
        return "front/ztreeDemo";
    }
}

