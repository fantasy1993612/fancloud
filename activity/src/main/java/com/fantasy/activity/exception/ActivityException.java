package com.fantasy.activity.exception;
/**
 * @Author: xiangming
 * @Date: 2020/2/4 01:14
 * @Description:活动异常
 */
public class ActivityException extends BaseException{

    public ActivityException(CommonErrorCode commonErrorCode) {
        super(commonErrorCode);
    }
}
