package com.fantasy.eurekaclient.service;

import com.fantasy.eurekaclient.entity.Activity;
import com.fantasy.eurekaclient.model.dto.ActivityDto;
import com.fantasy.eurekaclient.params.ActivityParam;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface IActivityService {

    /**
     *  保存活动
     * @param activityParam
     */
    void save(ActivityParam activityParam);
    /**
     * 分页查询活动
     * @param page
     * @return
     */
    Page<ActivityDto> queryActivityInfoByPage(Integer page);

    /**
     * 检查热门活动
     * @param activityId
     * @return
     */
    void checkHotActivity(Integer activityId);

    /**
     * 查询热门活动
     * @param id
     */
    Optional<Activity> queryHotActivity(Integer id);
}
