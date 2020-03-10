package com.fantasy.activity.model.response;

import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNull;

/**
 * @author: xiangming
 * @date: 2020/02/20 20:46
 * @describetion: 基础返回消息
 */
@Data
@NoArgsConstructor
public class BaseResponse<T> {

    /**
     * 返回码
     */
    private String code;
    /**
     * 返回信息
     */
    private String message;
    /**
     * 返回值
     */
    private T data;

    public BaseResponse(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     * 返回成功状态
     *
     * @param message
     * @param data
     * @param <T>
     * @return
     */
    @NonNull
    public static <T> BaseResponse<T> ok(String message, T data) {
        return new BaseResponse<>("0", message, data);
    }

    /**
     * 返回成功信息，无数据时
     *
     * @param message
     * @param <T>
     * @return
     */
    @NonNull
    public static <T> BaseResponse<T> ok(String message) {
        return new BaseResponse<>("0", message, null);
    }

    /**
     * 返回成功信息，只填充数据
     *
     * @param data
     * @param <T>
     * @return
     */
    public static <T> BaseResponse<T> ok(T data) {
        return new BaseResponse<>("0", HttpStatus.OK.getReasonPhrase(), data);
    }

    public static<T> BaseResponse<T> fail(String code,String message){
        return new BaseResponse<>(code,message,null);
    }
}
