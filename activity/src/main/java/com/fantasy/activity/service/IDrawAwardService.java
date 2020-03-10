package com.fantasy.activity.service;

import com.fantasy.activity.model.dto.AwardPrizeDto;
import com.fantasy.activity.model.params.DrawAwardParam;

/**
 * @author: xiangming
 * @date: 2020/1/30 8:17 PM
 * @describtion: 活动实体类
 */
public interface IDrawAwardService {

    /**
     * 抽奖
     * @param drawAwardParam
     * @return AwardPrizeDto
     */
    AwardPrizeDto drawAward(DrawAwardParam drawAwardParam);
}
