package com.fantasy.eurekaclient.params;

import com.fantasy.eurekaclient.entity.Activity;
import com.fantasy.eurekaclient.model.InputConverter;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * 活动入参
 */
@Data
public class ActivityParam implements InputConverter<Activity> {

    @NotBlank(message = "活动名称不能为空")
    @Size(max = 255, message = "活动名称长度不能超过 {max}")
    private String activityName;

    private String activityDescribe;

    @URL(message = "跳转地址格式不正确")
    private String skipUrl;

    @Min(value = 1, message = "活动状态最低为0 {value}")
    @Min(value = 3, message = "活动状态最高为3 {value}")
    private Integer status;

}
