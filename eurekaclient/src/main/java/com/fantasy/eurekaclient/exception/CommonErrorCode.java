package com.fantasy.eurekaclient.exception;

import lombok.Getter;

/**
 * @Auther: xiangming
 * @Date: 2020/2/4 01:05
 * @Description:
 */
@Getter
public enum CommonErrorCode {

    /**
     * 活动不存在错误
     */
    NOT_FOUND_ACTIVITY("0001", "活动不存在");

    /**
     * 错误码
     */
    private String code;
    /**
     * 错误消息
     */
    private String message;

    CommonErrorCode(String code, String message) {
        this.code = code;
        this.message = message;

    }

}
