package com.fantasy.activity.service;

import com.fantasy.activity.model.entity.AwardTimes;

import java.util.Optional;

/**
 * @author: xiangming
 * @date: 2020/02/29 02:23
 * @describetion:
 */
public interface IAwardTimesService {

    Optional<AwardTimes> queryAwardTimes(Integer activityId,String idNo);
}
