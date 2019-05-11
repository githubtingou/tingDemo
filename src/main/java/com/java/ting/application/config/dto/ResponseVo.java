package com.java.ting.application.config.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
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
}
