package com.fantasy.eurekaclient.params;

import com.fantasy.eurekaclient.entity.Activity;
import com.fantasy.eurekaclient.model.InputConverter;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

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

    @Min(value = 1, message = "活动状态最低为 {value}")
    @Max(value = 3, message = "活动状态最高为 {value}")
    private Integer status;

    //活动跳转方式
    private String skipWay;
    //活动图片id
    private String activityImgId;
    //活动开始时间
    private LocalDateTime startTime;
    //活动结束时间
    private LocalDateTime endTime;
    //活动状态 0 未开启 1已开启
    private Integer activityStatus;

}
