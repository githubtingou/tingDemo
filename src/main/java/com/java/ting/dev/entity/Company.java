package com.java.ting.dev.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.models.auth.In;

import java.util.List;

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getUnitCode() {
        return unitCode;
    }

    public void setUnitCode(String unitCode) {
        this.unitCode = unitCode;
    }

    public String getLegalRep() {
        return legalRep;
    }

    public void setLegalRep(String legalRep) {
        this.legalRep = legalRep;
    }

    public String getLegalTele() {
        return legalTele;
    }

    public void setLegalTele(String legalTele) {
        this.legalTele = legalTele;
    }

    public String getUnitAddr() {
        return unitAddr;
    }

    public void setUnitAddr(String unitAddr) {
        this.unitAddr = unitAddr;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactTele() {
        return contactTele;
    }

    public void setContactTele(String contactTele) {
        this.contactTele = contactTele;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getOtherAddress() {
        return otherAddress;
    }

    public void setOtherAddress(String otherAddress) {
        this.otherAddress = otherAddress;
    }

    public String getOtherZip() {
        return otherZip;
    }

    public void setOtherZip(String otherZip) {
        this.otherZip = otherZip;
    }

    public String getLimitTime() {
        return limitTime;
    }

    public void setLimitTime(String limitTime) {
        this.limitTime = limitTime;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getLicenseValid() {
        return licenseValid;
    }

    public void setLicenseValid(String licenseValid) {
        this.licenseValid = licenseValid;
    }

    public String getHylbfy() {
        return hylbfy;
    }

    public void setHylbfy(String hylbfy) {
        this.hylbfy = hylbfy;
    }

    public String getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(String coordinate) {
        this.coordinate = coordinate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRegistrationNum() {
        return registrationNum;
    }

    public void setRegistrationNum(String registrationNum) {
        this.registrationNum = registrationNum;
    }

    public String getLicenseNum() {
        return licenseNum;
    }

    public void setLicenseNum(String licenseNum) {
        this.licenseNum = licenseNum;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }


}
