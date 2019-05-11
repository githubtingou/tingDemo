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
    private String msg;

    ResponseCode(Boolean isSuccess, String msg) {
        this.isSuccess = isSuccess;
        this.msg = msg;

    }

    ResponseCode(Boolean isSuccess, Integer code, String msg) {
        this.isSuccess = isSuccess;
        this.code = code;
        this.msg = msg;

    }

    public Boolean getIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(Boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
