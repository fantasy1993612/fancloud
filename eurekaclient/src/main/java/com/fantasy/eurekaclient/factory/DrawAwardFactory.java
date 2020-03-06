package com.fantasy.eurekaclient.factory;

import com.fantasy.eurekaclient.repository.AwardConfigRepository;
import com.fantasy.eurekaclient.repository.AwardTimesRepository;
import com.fantasy.eurekaclient.service.IActivityService;
import com.fantasy.eurekaclient.service.IAwardPrizeService;
import com.fantasy.eurekaclient.service.IAwardTimesService;
import com.fantasy.eurekaclient.service.impl.AwardDistributeService;
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
