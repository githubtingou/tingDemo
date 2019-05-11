package com.java.ting.application.utils;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * 公共实体类
 * @author TingOu
 */
@Getter
@Setter
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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    protected Date createDate;
    /**
     * 更新者
     */

    protected String updateBy;
    /**
     * 更新日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    protected Date updateDate;
    /**
     * 删除标记（0：正常；1：删除；2：审核）
     */
    protected String delFlag = "0";


}
