package com.fantasy.activity;

/**
 * @author: xiangming
 * @date: 2020/02/20 21:48
 * @describetion:
 */

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description 打印请求参数和返回结果
 * @Date 2019/2/26 11:37
 * @author: gongxz
 */
@Aspect
@Configuration
@Slf4j
public class GlobalLog {

    /**
     * 定义切点
     */
    @Pointcut("execution(* com.fantasy.activity.controller..*.*(..))")
    public void executeService() {
    }

    @Around("executeService()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        HttpServletRequest request = sra.getRequest();

        String url = request.getRequestURL().toString();
        String method = request.getMethod();
        String queryString = request.getQueryString();
        Object[] args = pjp.getArgs();
        String params = "";
        //获取请求参数集合并进行遍历拼接
        if (args.length > 0) {
            if ("POST".equals(method)) {
                Object object = args[0];
                Map map = getKeyAndValue(object);
                params = JSON.toJSONString(map);
            } else if ("GET".equals(method)) {
                params = URLDecoder.decode(queryString, "UTF-8");
            }
        }

        log.info("请求开始===地址:" + url);
        log.info("请求开始===类型:" + method);
        log.info("请求开始===参数:" + params);

        // result的值就是被拦截方法的返回值
        Object result = pjp.proceed();
        log.info("请求结束===返回值:" + JSON.toJSON(result));
        return result;
    }

    public static Map<String, Object> getKeyAndValue(Object obj) {
        Map<String, Object> map = new HashMap<>();
        // 得到类对象
        Class userCla = obj.getClass();
        /* 得到类中的所有属性集合 */
        Field[] fs = userCla.getDeclaredFields();
        for (Field f : fs) {
            f.setAccessible(true); // 设置些属性是可以访问的
            Object val;
            try {
                val = f.get(obj);
                // 得到此属性的值
                map.put(f.getName(), val);// 设置键值
            } catch (IllegalArgumentException | IllegalAccessException e) {
                e.printStackTrace();
            }

        }
        return map;
    }
}
