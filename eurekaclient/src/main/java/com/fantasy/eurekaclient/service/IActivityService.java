package com.fantasy.eurekaclient.service;

import com.fantasy.eurekaclient.model.entity.Activity;
import com.fantasy.eurekaclient.model.dto.ActivityDto;
import com.fantasy.eurekaclient.model.params.ActivityParam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import java.util.Optional;

/**
 * @author: xiangming
 * @date: 2020/1/30 8:17 PM
 * @describtion: 活动实体类
 */
public interface IActivityService {

    /**
     * 保存活动
     *
     * @param activityParam
     */
    void save(ActivityParam activityParam);

    /**
     * 分页查询活动
     *
     * @param currentPage
     * @param pageSize
     * @param sort
     * @return
     */
    Page<ActivityDto> queryActivityInfoByPage(Integer currentPage, Integer pageSize, Sort sort);

    /**
     * 检查热门活动
     *
     * @param activityId
     * @return
     */
    void checkHotActivity(Integer activityId);

    /**
     * 查询热门活动
     *
     * @param id
     * @return Optional<Activity>
     */
    Optional<Activity> queryHotActivity(Integer id);

    /**
     * 查询热门活动列表
     *
     * @param currentPage
     * @param pageSize
     * @return Page<ActivityDto>
     */
    Page<ActivityDto> queryHotActivityInfo(Integer currentPage, Integer pageSize);

}
