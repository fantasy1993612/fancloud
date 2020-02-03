package com.fantasy.eurekaclient.exception;


import lombok.Data;

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
