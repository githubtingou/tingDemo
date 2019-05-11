package com.java.ting.application.config.dto;

import com.java.ting.application.config.enums.ResponseCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 返回参数封装
 *
 * @author TingOu
 */
@Setter
@Getter
@ToString
public class ResponseVo<T> {
    private Boolean isSuccess;
    private Integer code;
    private String msg;
    private T data;

    public ResponseVo() {

    }

    public ResponseVo(Boolean isSuccess, Integer code, String msg, T data) {
        this.isSuccess = isSuccess;
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public ResponseVo(ResponseCode responseCode, T data) {
        this.isSuccess = responseCode.getIsSuccess();
        this.code = responseCode.getCode();
        this.msg = responseCode.getMsg();
        this.data = data;
    }
}
