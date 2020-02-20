package com.fantasy.eurekaclient;

import com.fantasy.eurekaclient.exception.ActivityException;
import com.fantasy.eurekaclient.model.response.BaseResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.HashMap;
import java.util.Map;

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
