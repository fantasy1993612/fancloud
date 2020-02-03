package com.fantasy.eurekaclient.service.impl;

import com.fantasy.eurekaclient.dao.AwardPrizeRepository;
import com.fantasy.eurekaclient.dao.AwardTimesRepository;
import com.fantasy.eurekaclient.entity.AwardPrize;
import com.fantasy.eurekaclient.entity.AwardTimes;
import com.fantasy.eurekaclient.params.DrawAwardParam;
import com.fantasy.eurekaclient.service.IActivityService;
import com.fantasy.eurekaclient.service.IAwardPrizeService;
import com.fantasy.eurekaclient.service.IDrawAwardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: xiangming
 * @Date: 2020-02-02-00:23
 * @Describetion: 抽奖实现类
 */
@Service
public class DrawAwardServiceImpl implements IDrawAwardService {

    @Autowired
    private IActivityService activityService;

    @Autowired
    private AwardPrizeRepository awardPrizeRepository;

    @Autowired
    private AwardTimesRepository awardTimesRepository;

    @Autowired
    private IAwardPrizeService awardPrizeService;


    @Transactional
    public AwardPrize drawAward(DrawAwardParam drawAwardParam) {
        //检查热门活动
        activityService.checkHotActivity(drawAwardParam.getActivityId());
        //保存领取次数
        awardTimesRepository.save(buildAwardTimes(drawAwardParam.getActivityId()));
        //查询奖品列表
        List<AwardPrize> awardPrizeList = awardPrizeService.
                queryAwardInfo(drawAwardParam.getActivityId());
        AwardPrize awardPrize = awardPrizeList.get(0);
        //派奖 异步 注解的话要在另外一个累中写

        //扣减奖品数量
        awardPrizeRepository.updateAwardRemainNum(awardPrize.getId());
        //保存中奖记录
        //返回奖品
        return awardPrize;

    }

    @Async
    public AwardTimes buildAwardTimes(Integer activityId) {
        AwardTimes awardTimes = new AwardTimes();
        awardTimes.setActivityId(activityId);
        awardTimes.setAwardTimes(1);
        return awardTimes;
    }

}
