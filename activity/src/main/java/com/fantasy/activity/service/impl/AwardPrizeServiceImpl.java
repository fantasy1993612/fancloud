package com.fantasy.activity.service.impl;

import com.fantasy.activity.model.entity.AwardPrize;
import com.fantasy.activity.repository.AwardPrizeRepository;
import com.fantasy.activity.service.IAwardPrizeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: xiangming
 * @Date: 2020-02-03-18:16
 * @Describetion
 */
@Slf4j
@Service
public class AwardPrizeServiceImpl implements IAwardPrizeService {

    @Autowired
    private AwardPrizeRepository awardPrizeRepository;

    @Override
    @Cacheable(value = "activity",key = "'activity:awardInfo:'+#activityId")
    public List<AwardPrize> queryAwardInfo(Integer activityId) {
        List<AwardPrize> awardPrizeList = awardPrizeRepository.
                findByActivityId(activityId);
        log.info("开始查询奖项");
        return awardPrizeList;
    }
}
