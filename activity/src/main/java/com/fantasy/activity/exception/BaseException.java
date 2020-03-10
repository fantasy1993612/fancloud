package com.fantasy.activity.exception;


import lombok.Data;

/**
 * @author: xiangming
 * @date: 2020/1/30 8:17 PM
 * @describtion: 基础类异常
 */
@Data
public class BaseException extends RuntimeException {

    private String code;

    public BaseException(CommonErrorCode commonErrorCode){
        super(commonErrorCode.getMessage());
        this.code = commonErrorCode.getCode();
    }

    public BaseException(String code,String message){
        super(message);
        this.code = code;
    }



}
