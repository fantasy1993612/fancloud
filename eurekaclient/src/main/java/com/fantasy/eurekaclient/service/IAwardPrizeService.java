package com.fantasy.eurekaclient.service;

import com.fantasy.eurekaclient.entity.AwardPrize;

import java.util.List;

/**
 * @author: xiangming
 * @date: 2020/1/30 8:17 PM
 * @describtion: 活动实体类
 */
public interface IAwardPrizeService {

    /**
     * 查询奖品信息
     * @param activityId
     * @return List<AwardPrize>
     */
    List<AwardPrize>  queryAwardInfo(Integer activityId);

}
