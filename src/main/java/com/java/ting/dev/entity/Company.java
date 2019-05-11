package com.java.ting.dev.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.models.auth.In;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 公司实体类
 *
 * @author TingOu
 */
@Setter
@Getter
public class Company {

    private String id;//id
    private String unitName;  //单位名称
    private String zipCode;  //邮政编码
    private String unitCode;  //组织机构代码
    private String legalRep;  //法人代表
    private String legalTele; //法人联系电话
    private String unitAddr;  //单位地址
    private String contactName;  //联系人
    private String contactTele;  //联系人联系电话
    private String fax;  //传真号码
    private String mail; //电子邮件
    private String otherAddress;  //其他地址
    private String otherZip;  //其他地址邮政编码
    private String limitTime;  //许可证有效期
    private String area;  //区域
    private String licenseValid; //颁发日期
    private String hylbfy;  //行业类别
    private String coordinate; //经纬度（逗号隔开，前面经度后面纬度）
    private String remark;  //单位简介
    private String registrationNum; //企业排污登记号
    private String licenseNum; //法人联系电话

}
