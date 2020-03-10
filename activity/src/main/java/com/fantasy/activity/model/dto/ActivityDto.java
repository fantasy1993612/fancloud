package com.fantasy.activity.model.dto;

import com.fantasy.activity.model.OutputConverter;
import com.fantasy.activity.model.entity.Activity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @Author: xiangming
 * @Date: 2020-02-06-19:15
 * @Describetion:活动Dto类
 */
@ApiModel(description = "活动Dto")
@Data
public class ActivityDto implements OutputConverter<ActivityDto,Activity> {

    /**
     * 活动名称
     */
    @ApiModelProperty(value = "活动名称", example = "活动")
    private String activityName;
    /**
     * 活动开始时间
     */
    @ApiModelProperty(value = "活动开始时间", example = "活动")
    private LocalDateTime startTime;
    /**
     * 活动结束时间
     */
    @ApiModelProperty(value = "活动结束时间", example = "活动")
    private LocalDateTime endTime;
    /**
     * 活动状态 0 未开启 1已开启
     */
    @ApiModelProperty(value = "活动状态", example = "活动")
    private Integer activityStatus;

}
