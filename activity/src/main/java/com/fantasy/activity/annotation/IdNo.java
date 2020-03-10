package com.fantasy.activity.annotation;

import java.lang.annotation.*;

/**
 * @author: xiangming
 * @date: 2020/03/01 01:49
 * @describetion:
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface IdNo {

    String idNo() default "";

    String message() default "身份证号不合法";

}
