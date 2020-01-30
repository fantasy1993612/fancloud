package com.fantasy.eurekaclient.service.impl;

import com.fantasy.eurekaclient.dao.ActivityRepository;
import com.fantasy.eurekaclient.entity.Activity;
import com.fantasy.eurekaclient.params.ActivityParam;
import com.fantasy.eurekaclient.service.IActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActivityServiceImpl implements IActivityService {

    @Autowired
    private ActivityRepository activityRepository;

    @Override
    public void save(ActivityParam activityParam) {
        Activity activity = activityParam.convertTo();
        activityRepository.save(activity);
    }
}
