package com.fantasy.activity.controller;

import com.fantasy.activity.model.dto.ActivityDto;
import com.fantasy.activity.service.IActivityService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.SortDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.data.domain.Sort.Direction.ASC;

/**
 * @Author: xiangming
 * @Date: 2020/02/02 00:22
 * @Describetion
 */
@Slf4j
@RestController
@RequestMapping(value = "/activity")
public class ActivityController {

    @Autowired
    private IActivityService activityService;

    @ApiOperation(value = "查询热门活动", response = ActivityDto.class)
    @GetMapping("/queryActivity")
    public Page<ActivityDto> queryActivityInfo(Integer currentPage, Integer pageSize,
                                               @SortDefault.SortDefaults({
                                                       @SortDefault(sort = "createTime", direction = ASC)
                                               }) Sort sort) {
        return activityService.queryActivityInfoByPage(currentPage, pageSize, sort);
    }
}