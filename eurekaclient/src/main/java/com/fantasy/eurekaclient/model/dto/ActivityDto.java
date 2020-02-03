package com.fantasy.eurekaclient.model.dto;

import com.fantasy.eurekaclient.entity.Activity;
import com.fantasy.eurekaclient.model.OutputConverter;

import java.time.LocalDateTime;

public class ActivityDto implements OutputConverter<ActivityDto,Activity> {

    /**
     * 活动名称
     */
    private String activityName;
    //活动开始时间
    private LocalDateTime startTime;
    //活动结束时间
    private LocalDateTime endTime;
    //活动状态 0 未开启 1已开启
    private Integer activityStatus;

}