package com.fantasy.eurekaclient.exception;

import lombok.Data;
import lombok.Getter;

/**
 * @Auther: xiangming
 * @Date: 2020/2/4 01:05
 * @Description:
 */
@Getter
public enum CommonErrorCode {

    NOT_FOUND_ACTIVITY("0001", "活动不存在");

    private String code;

    private String message;

    CommonErrorCode(String code, String message) {
        this.code = code;
        this.message = message;

    }

}
