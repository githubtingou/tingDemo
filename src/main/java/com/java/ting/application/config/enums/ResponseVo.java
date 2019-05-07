package com.java.ting.application.config.enums;

public enum ResponseVo {
    successCode(true,"success"),
    errorCode(false,"error");

    private Boolean b;
    private String desc;
    ResponseVo(Boolean b,String desc) {
        this.b=b;
        this.desc = desc;

    }

    public Boolean getB() {
        return b;
    }

    public void setB(Boolean b) {
        this.b = b;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
