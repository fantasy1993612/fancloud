package com.fantasy.eurekaclient.exception;

import lombok.Getter;

/**
 * @author: xiangming
 * @date: 2020/1/30 8:17 PM
 * @describtion: 错误码
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
