package com.fantasy.activity;

import com.fantasy.activity.exception.ActivityException;
import com.fantasy.activity.model.response.BaseResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author: xiangming
 * @date: 2020/1/30 8:17 PM
 * @describtion: 统一异常分处理
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ActivityException.class)
    public BaseResponse handleGlobalException(ActivityException e) {
        return BaseResponse.fail(e.getCode(),e.getMessage());
    }
}
