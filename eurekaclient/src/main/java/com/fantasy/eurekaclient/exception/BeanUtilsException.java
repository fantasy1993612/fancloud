package com.fantasy.eurekaclient.exception;

import org.springframework.http.HttpStatus;

/**
 * BeanUtils exception.
 *
 * @author johnniang
 */
public class BeanUtilsException extends BaseException {

    public BeanUtilsException(CommonErrorCode commonErrorCode) {
        super(commonErrorCode);
    }

}
