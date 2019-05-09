package com.java.ting.application.config.enums;

/**
 * 返回参数封装
 *
 * @author TingOu
 */
public enum ResponseCode {
    /**
     * success
     */
    successCode(true, 200, "请求成功"),
    /**
     * error
     */
    errorCode(false, 400, "请求失败");

    private Boolean isSuccess;
    private Integer code;
    private String desc;

    ResponseCode(Boolean isSuccess, String desc) {
        this.isSuccess = isSuccess;
        this.desc = desc;

    }

    ResponseCode(Boolean isSuccess, Integer code, String desc) {
        this.isSuccess = isSuccess;
        this.code = code;
        this.desc = desc;

    }

    public Boolean getIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(Boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
