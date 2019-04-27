package com.java.ting.application.utils;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * 公共实体类
 */
public class BaseEntity<T> {
    /**
     * id
     */
    protected String id;
    /**
     * 备注
     */
    protected String remarks;
    /**
     * 创建者
     */
    protected String createBy;
    /**
     * 创建日期
     */
    protected Date createDate;
    /**
     * 更新者
     */
    protected String updateBy;
    /**
     * 更新日期
     */
    protected Date updateDate;
    /**
     * 删除标记（0：正常；1：删除；2：审核）
     */
    protected String delFlag;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }


}
