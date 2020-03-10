package com.fantasy.activity.factory;

import com.fantasy.activity.repository.AwardConfigRepository;
import com.fantasy.activity.repository.AwardTimesRepository;
import com.fantasy.activity.service.IActivityService;
import com.fantasy.activity.service.IAwardPrizeService;
import com.fantasy.activity.service.IAwardTimesService;
import com.fantasy.activity.service.impl.AwardDistributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * @author: xiangming
 * @date: 2020/02/25 03:14
 * @describetion:
 */
public class DrawAwardFactory<T> implements DistributeFactory<T>{

    @Autowired
    private IActivityService activityService;

    @Autowired
    private AwardConfigRepository awardConfigRepository;

    @Autowired
    private AwardTimesRepository awardTimesRepository;

    @Autowired
    private IAwardPrizeService awardPrizeService;

    @Autowired
    private AwardDistributeService awardDistributeService;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private IAwardTimesService awardTimesService;

    @Override
    public IDistributeAward createDistibute() {
        return new DrawAward();
    }
}
