package com.fantasy.eurekaclient.service.impl;

import com.fantasy.eurekaclient.dao.ActivityRepository;
import com.fantasy.eurekaclient.entity.Activity;
import com.fantasy.eurekaclient.exception.ActivityException;
import com.fantasy.eurekaclient.exception.CommonErrorCode;
import com.fantasy.eurekaclient.model.dto.ActivityDto;
import com.fantasy.eurekaclient.params.ActivityParam;
import com.fantasy.eurekaclient.service.IActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
    public Page<ActivityDto> queryActivityInfoByPage(Integer  page){
        Sort sort = new Sort(Sort.Direction.ASC, "updateTime");
        Pageable pageable = PageRequest.of(page,2, sort);

        Page<Activity> activityPage = activityRepository.findAll(pageable);
        return activityPage.map(this::convertToDto);
    }

    @Override
    public void checkHotActivity(Integer activityId) {
        Optional<Activity> activity = queryHotActivity(activityId);
        if(!activity.isPresent()){
            throw new ActivityException(CommonErrorCode.NOT_FOUND_ACTIVITY);
        }
    }

    @Override
    @Cacheable(value = "activity",key = "'activity:hotActivity:'+#activityId")
    public Optional<Activity> queryHotActivity(Integer activityId) {
        return activityRepository.findById(activityId);
    }

    public ActivityDto convertToDto(Activity activity){
            return new ActivityDto().convertFrom(activity);
    }

}
