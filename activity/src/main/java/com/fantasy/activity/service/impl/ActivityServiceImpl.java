package com.fantasy.activity.service.impl;

import com.fantasy.activity.exception.ActivityException;
import com.fantasy.activity.exception.CommonErrorCode;
import com.fantasy.activity.model.dto.ActivityDto;
import com.fantasy.activity.model.entity.Activity;
import com.fantasy.activity.model.params.ActivityParam;
import com.fantasy.activity.repository.ActivityRepository;
import com.fantasy.activity.service.IActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author: xiangming
 * @date: 2020/1/30 8:17 PM
 * @describtion: 活动实体类
 */
@Service
public class ActivityServiceImpl implements IActivityService {

    @Autowired
    private ActivityRepository activityRepository;

    @Override
    public void save(ActivityParam activityParam) {
        Activity activity = activityParam.convertTo();
        activityRepository.save(activity);
    }

    @Override
    public Page<ActivityDto> queryActivityInfoByPage(Integer currentPage, Integer pageSize, Sort sort) {
        Pageable pageable = PageRequest.of(currentPage, pageSize, sort);
        Page<Activity> activityPage = activityRepository.findAll(pageable);
        return activityPage.map(this::convertToDto);
    }

    @Override
    public void checkHotActivity(Integer activityId) {
        Optional<Activity> activity = queryHotActivity(activityId);
        if (!activity.isPresent()) {
            throw new ActivityException(CommonErrorCode.NOT_FOUND_ACTIVITY);
        }
    }

    @Override
    @Cacheable(value = "activity", key = "'activity:hotActivity:'+#activityId")
    public Optional<Activity> queryHotActivity(Integer activityId) {
        return activityRepository.findById(activityId);
    }

    @Override
    public Page<ActivityDto> queryHotActivityInfo(Integer currentPage, Integer pageSize) {
        Sort sort = new Sort(Sort.Direction.ASC, "createTime");
        Page<Activity> activityPage = activityRepository.
                findAll(Example.of(buildQueryActivity()), PageRequest.of(currentPage, pageSize, sort));
        return activityPage.map(this::convertToDto);

    }

    public ActivityDto convertToDto(Activity activity) {
        return new ActivityDto().convertFrom(activity);
    }

    public Activity buildQueryActivity() {
        Activity activity = new Activity();
        activity.setStatus(2);
        activity.setActivityStatus(1);
        return activity;
    }

}
