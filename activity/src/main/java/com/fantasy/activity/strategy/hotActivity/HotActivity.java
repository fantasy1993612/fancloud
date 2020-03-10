package com.fantasy.activity.strategy.hotActivity;

import com.fantasy.activity.model.params.DrawAwardParam;
import com.fantasy.activity.service.IActivityService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author: xiangming
 * @date: 2020/02/25 02:55
 * @describetion:
 */
public class HotActivity<T extends DrawAwardParam> implements IHotActivity<T> {

    @Autowired
    private IActivityService activityService;


    @Override
    public boolean checkActivity(T t) {
        activityService.checkHotActivity(t.getActivityId());
        return true;
    }
}
