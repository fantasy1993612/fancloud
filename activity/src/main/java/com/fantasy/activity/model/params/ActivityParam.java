package com.fantasy.activity.model.params;

import com.fantasy.activity.model.InputConverter;
import com.fantasy.activity.model.entity.Activity;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

/**
 * @author: xiangming
 * @date: 2020/1/30 8:17 PM
 * @describtion: 活动实体类
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

    private String skipWay;

    private String activityImgId;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private Integer activityStatus;

}
