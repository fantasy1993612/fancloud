package com.fantasy.activity.service.impl;

import com.fantasy.activity.constant.DrawLevelLimitEnum;
import com.fantasy.activity.model.dto.AwardPrizeDto;
import com.fantasy.activity.model.entity.AwardConfig;
import com.fantasy.activity.model.entity.AwardPrize;
import com.fantasy.activity.model.entity.AwardTimes;
import com.fantasy.activity.repository.AwardConfigRepository;
import com.fantasy.activity.repository.AwardTimesRepository;
import com.fantasy.activity.service.IAwardTimesService;
import com.fantasy.activity.model.params.DrawAwardParam;
import com.fantasy.activity.service.IActivityService;
import com.fantasy.activity.service.IAwardPrizeService;
import com.fantasy.activity.service.IDrawAwardService;
import com.google.common.util.concurrent.RateLimiter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

/**
 * @Author: xiangming
 * @Date: 2020-02-02-00:23
 * @Describetion: 抽奖实现类 非策略模式
 */
@Slf4j
@Service
public class DrawAwardServiceImpl implements IDrawAwardService {

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


    @Transactional(rollbackFor = Exception.class)
    @Override
    public AwardPrizeDto drawAward(DrawAwardParam drawAwardParam) {
        RateLimiter rateLimiter = RateLimiter.create(5);
        log.info("等待时间：{}", rateLimiter.acquire());
        if (!rateLimiter.tryAcquire(1000, TimeUnit.MILLISECONDS)) {
            log.info("短期无法获取令牌");
        }
        //检查热门活动
        activityService.checkHotActivity(drawAwardParam.getActivityId());

        Optional<AwardTimes> awardTimes = awardTimesService.queryAwardTimes(drawAwardParam.getActivityId(),
                drawAwardParam.getIdNo());
        //保存/更新领取次数
        awardTimesRepository.save(buildAwardTimes(awardTimes,drawAwardParam.getActivityId()));

        //查询奖品列表
        List<AwardPrize> awardPrizeList = awardPrizeService.
                queryAwardInfo(drawAwardParam.getActivityId());

        AwardPrize awardPrize = awardPrizeList.get(1);

        //检查限制奖品数量
        redisTemplate.opsForSet().isMember("activity:awardLimit:" + awardPrize.getId(),
                LocalDateTime.now().getHour());

        //领取一等奖不能再领
        if (checkDrawLimit(drawAwardParam.getActivityId(), drawAwardParam.getIdNo())) {
            awardPrize = awardPrizeList.get(0);
            log.debug("用户不符合限制条件派发谢谢参与");
        }

        //扣减奖品数量 O(1)
        redisTemplate.opsForValue().decrement("activity:awardRemain:" + awardPrize.getId(), 1);
        log.info("开始派奖：{}", awardPrize.getId());
        awardDistributeService.distibuteAward(awardPrize);
        return new AwardPrizeDto().convertFrom(awardPrize);
    }

    /**
     * 检查抽奖限制
     *
     * @param activityId
     * @param idNo
     * @return
     */
    public boolean checkDrawLimit(Integer activityId, String idNo) {
        AwardConfig awardConfig = queryAwardConfig(activityId);
        log.debug("查询到的奖品限制：{}", awardConfig.getAwardLevelLimit());

        Integer awardLevelLimit = awardConfig.getAwardLevelLimit();
        if (DrawLevelLimitEnum.LIMIT_DRAW_FIRST_PRIZE.ordinal() == awardLevelLimit) {
            log.debug("检查是否抽中过一等奖");
            return checkIfDrawFirstPrize(activityId, idNo);
        }
        if (awardLevelLimit == DrawLevelLimitEnum.LIMIT_DRAW_PRIZE.ordinal()) {
            log.debug("检查是否抽中过奖");
            return checkIfDrawPrize(activityId, idNo);
        }
        return true;
    }

    /**
     * 查询奖品配置信息
     *
     * @param activityId
     * @return
     */
    private AwardConfig queryAwardConfig(Integer activityId) {
        AwardConfig awardConfig = new AwardConfig();
        awardConfig.setActivityId(activityId);
        Example<AwardConfig> awardConfigExample = Example.of(awardConfig);
        Optional<AwardConfig> awardConfigOptional = awardConfigRepository.
                findOne(awardConfigExample);
        return awardConfigOptional.get();
    }

    /**
     * 检查一等奖是否抽取过
     *
     * @param activityId
     * @param idNo
     * @return
     */
    public boolean checkIfDrawFirstPrize(Integer activityId, String idNo) {
        AwardTimes awardTimes = buildDrawTimes(activityId, idNo);
        awardTimes.setFirstPrizeCount(0);

        Example<AwardTimes> awardTimesExample = Example.of(awardTimes);
        return !awardTimesRepository.exists(awardTimesExample);
    }

    /**
     * 检查是否抽过奖
     *
     * @param activityId
     * @param idNo
     * @return
     */
    public boolean checkIfDrawPrize(Integer activityId, String idNo) {
        AwardTimes awardTimes = buildDrawTimes(activityId, idNo);
        awardTimes.setDrawPrizeCount(0);
        Example<AwardTimes> awardTimesExample = Example.of(awardTimes);
        return !awardTimesRepository.exists(awardTimesExample);
    }

    /**
     * 构建抽奖
     *
     * @param activityId
     * @param idNo
     * @return
     */
    public AwardTimes buildDrawTimes(Integer activityId, String idNo) {
        AwardTimes awardTimes = new AwardTimes();
        awardTimes.setActivityId(activityId);
        awardTimes.setIdNo(idNo);
        return awardTimes;
    }

    public AwardTimes buildAwardTimes(Optional<AwardTimes> awardTimesOptional,Integer activityId) {
        AwardTimes awardTimes = new AwardTimes();
        if(awardTimesOptional.isPresent()){
            awardTimes = awardTimesOptional.get();
        }else{
            awardTimes.setAwardTimes(1);
        }
        awardTimes.setActivityId(activityId);
        return awardTimes;
    }

}
