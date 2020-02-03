package com.fantasy.eurekaclient;/**
 * @Auther: xiangming
 * @Date: 2020/2/4 01:18
 * @Description:
 */


import com.fantasy.eurekaclient.exception.ActivityException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: xiangming
 * @Date: 2020/2/4 01:18
 * @Description: 统一异常处理
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ActivityException.class)
    public Map<String, Object> handleUserNotExistsException(ActivityException e) {
        Map<String, Object> map = new HashMap<>();
        map.put("code", e.getCode());
        map.put("message", e.getMessage());
        return map;
    }
}
