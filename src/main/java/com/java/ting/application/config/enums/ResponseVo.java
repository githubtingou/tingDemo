package com.java.ting.application.config.enums;

/**
 * 返回参数封装
 *
 * @author TingOu
 */
public enum ResponseVo {
    /**
     * success
     */
    successCode(true, "success"),
    /**
     * error
     */
    errorCode(false, "error");

    private Boolean isBoolean;
    private String desc;

    ResponseVo(Boolean isBoolean, String desc) {
        this.isBoolean = isBoolean;
        this.desc = desc;

    }

    public Boolean getIsBoolean() {
        return isBoolean;
    }

    public void setIsBoolean(Boolean isBoolean) {
        this.isBoolean = isBoolean;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
