# tingDemo

## 项目介绍
    Spring boot初学

## 软件架构
    spring boot,mybatis,Spring security,Mysql 5.7,thymeleaf，mybatis-plus
## 开发规范
    1.命名规则：使用驼峰命名法;
    2.注解规范：javaDoc格式;
    3.dao和service方法命名规范:
        getEmpty();	单个信息查询；
        insertEmpty();插入一条数据；
        updateEmpty();更新一条；
        listEmpty();俩到三条查询条件；
        listUserByUser(); 三个以上查询条件；
        pageEmpty();需要分页
        其他：一个查询条件直接使用ByField;如果查询条件有多个看查询条件按需求添加Or;And;BetweenField0AndFiled1
        例子：获取单条：根据id查询：getUserById(String id);根据name和age查询：listUserByNameAndAge();如果查询条件过多使用listUserByuser()
##数据库设计
###1.表格公共字段：
        status：0：启用；1：新建；2：禁用
        del_flag: 0：正常（默认0）；1：删除
        sex: 0：女性；1：男性； 2:未知
        add_time: 创建时间
        update_time： 更新时间
        add_user: 创建人
        update_user: 更新人
###2.用户表：
        表：admin_user
        字段：id,login_name,real_name,login_img,password,age,sex,wx,qq,phone,email,add_time,update_time,add_user,update_user,del_flag,status,remark
        修改记录表；update_admin_user
        字段：id ,admin_user_id,update_field(1.name;2.password;3.wx;4.qq;5.phone;6.email),befor_data,add_time,update_time,add_user,update_user,del_flag
###3.菜单
        表：admin_menu
        字段 id,name,icon,url,parent_id,sort,,type(1:菜单，2:按钮),status,add_time,update_time,del_flag,add_user,update_user,;
        实现 1.首先将数据从数据库中根据用户读取出菜单栏信ListAllMenu();并根据parent_id字段遍历成json； 2.ajax获取数据foreach遍历到html页面；
        三，权限表
        表：role
        字段：id,role_name,describe,add_time,update_time,add_user,update_user,del_flag,
###4.权限和菜单栏关联表：
        表：role_and_admin_menu
        字段 role_id,admin_menu_id
###5.机构表
        表：organ
        字段：id,organ_name,parent_id,add_time,update_time,add_user,update_user,del_flag
###6.权限和机构管理表
        表：organ_and_role
        字段：organ_id,role_id
###7.后台日志表（暂定字段）
        表：sys_log
        字段：id,name,req_url,req_message,add_time,add_user,
        实现方式，应该会使用AOP实现日志
##后端
    1.基本框架--java,spring boot,spring,spring mvc,mybatis,spring aop,
    2.权限框架--spring secuirty
    4.数据库----mysql5.7
##前端
    1.基本：Jquery,bootstrap,
    2.页面模板：admintlte
    3.表格插件：bootstrap table,
    4.时间插件：My97DatePicker
    5.表单验证: jQuery.validator
    6.弹出框插件：layui
    7.下拉框插件：Select2
    8.树状图插件：ztree
    9.图表插件：echart
    10.前端框架--thymeleaf