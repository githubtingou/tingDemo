package com.java.ting.application.config.utils;

import com.google.gson.Gson;
import com.java.ting.application.config.dto.ResponseVo;
import com.java.ting.application.config.enums.ResponseCode;

import java.util.List;

/**
 * 封装ResponseVo工具类
 *
 * @author TingOu
 */
public class ResponseVoUtil {

    /**
     * 根据RespondeCode 返回参数
     *
     * @param responseCode
     * @param data
     * @return
     */
    public ResponseVo buildeResponseCode(ResponseCode responseCode, Object data) {
        return new ResponseVo(responseCode, data);

    }

    /**
     * 根据输入的参数返回参数
     *
     * @param isSuccess
     * @param code
     * @param msg
     * @param data
     * @return
     */
    public ResponseVo buildeResponseVo(boolean isSuccess, Integer code, String msg, Object data) {
        return new ResponseVo(isSuccess, code, msg, data);
    }
}
