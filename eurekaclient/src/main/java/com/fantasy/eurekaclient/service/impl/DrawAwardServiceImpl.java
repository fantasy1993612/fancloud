package com.fantasy.eurekaclient.service.impl;

import com.fantasy.eurekaclient.dao.AwardPrizeRepository;
import com.fantasy.eurekaclient.dao.AwardTimesRepository;
import com.fantasy.eurekaclient.entity.AwardPrize;
import com.fantasy.eurekaclient.entity.AwardTimes;
import com.fantasy.eurekaclient.model.dto.AwardPrizeDto;
import com.fantasy.eurekaclient.params.DrawAwardParam;
import com.fantasy.eurekaclient.service.IActivityService;
import com.fantasy.eurekaclient.service.IAwardPrizeService;
import com.fantasy.eurekaclient.service.IDrawAwardService;
import com.google.common.util.concurrent.RateLimiter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StopWatch;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Author: xiangming
 * @Date: 2020-02-02-00:23
 * @Describetion: 抽奖实现类
 */
@Slf4j
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

    @Autowired
    private AwardDistributeService awardDistributeService;

    @Autowired
    private StringRedisTemplate redisTemplate;


    @Transactional(rollbackFor = Exception.class)
    @Override
    public AwardPrizeDto drawAward(DrawAwardParam drawAwardParam) {
        RateLimiter rateLimiter = RateLimiter.create(5);
        log.info("等待时间：{}", rateLimiter.acquire());
        if (!rateLimiter.tryAcquire(1000, TimeUnit.MILLISECONDS)) {
            log.info("短期无法获取令牌，真不幸，排队也瞎排");
        }
        StopWatch stopWatch = new StopWatch("开始打印时间");
        stopWatch.start("检查热门活动");
        //检查热门活动
        activityService.checkHotActivity(drawAwardParam.getActivityId());
        stopWatch.stop();
        stopWatch.start("保存领取次数");
        //保存领取次数
        awardTimesRepository.save(buildAwardTimes(drawAwardParam.getActivityId()));
        stopWatch.stop();
        stopWatch.start("开始查询奖品列表");
        //查询奖品列表
        List<AwardPrize> awardPrizeList = awardPrizeService.
                queryAwardInfo(drawAwardParam.getActivityId());
        AwardPrize awardPrize = awardPrizeList.get(0);
        stopWatch.stop();
        stopWatch.start("开始扣减奖品数量");
        redisTemplate.opsForValue().decrement(String.valueOf(awardPrize.getId()),1);
        stopWatch.stop();
        log.info("开始派奖：{}",awardPrize.getId());
        stopWatch.start("异步发放奖品");
        awardDistributeService.distibuteAward(awardPrize);
        stopWatch.stop();
        log.info("总耗时：{}",stopWatch.prettyPrint());
        return new AwardPrizeDto().convertFrom(awardPrize);

    }

    @Async
    public AwardTimes buildAwardTimes(Integer activityId) {
        AwardTimes awardTimes = new AwardTimes();
        awardTimes.setActivityId(activityId);
        awardTimes.setAwardTimes(1);
        return awardTimes;
    }

}
