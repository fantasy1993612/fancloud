package com.fantasy.activity.constant;

import com.fantasy.activity.annotation.IdNo;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author: xiangming
 * @date: 2020/03/01 01:53
 * @describetion:注解校验器
 */
public class IdNoValidator implements ConstraintValidator<IdNo,String> {
    private String idNo;

    @Override
    public void initialize(IdNo idNo) {
        this.idNo = idNo.idNo();
    }
    @Override
    public boolean isValid(String idNo, ConstraintValidatorContext constraintValidatorContext) {
        if(idNo.equals(idNo)){
            return true;
        }
        return false;
    }
}
