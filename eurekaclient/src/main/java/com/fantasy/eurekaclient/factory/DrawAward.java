package com.fantasy.eurekaclient.factory;

import com.fantasy.eurekaclient.constant.DrawLevelLimitEnum;
import com.fantasy.eurekaclient.model.entity.AwardConfig;
import com.fantasy.eurekaclient.model.entity.AwardPrize;
import com.fantasy.eurekaclient.model.entity.AwardTimes;
import com.fantasy.eurekaclient.model.params.DrawAwardParam;
import com.fantasy.eurekaclient.repository.AwardConfigRepository;
import com.fantasy.eurekaclient.repository.AwardTimesRepository;
import com.fantasy.eurekaclient.service.IActivityService;
import com.fantasy.eurekaclient.service.IAwardPrizeService;
import com.fantasy.eurekaclient.service.IAwardTimesService;
import com.fantasy.eurekaclient.service.impl.AwardDistributeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * @author: xiangming
 * @date: 2020/02/25 15:33
 * @describetion:
 */
@Slf4j
public class DrawAward<T extends DrawAwardParam> implements IDistributeAward<T> {

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
    public boolean checkActivity(T t) {
        activityService.checkHotActivity(t.getActivityId());
        return true;
    }

    @Override
    public boolean checkQualify(T t) {
        Optional<AwardTimes> awardTimes = awardTimesService.queryAwardTimes(t.getActivityId(),
                t.getIdNo());
        //保存/更新领取次数
        awardTimesRepository.save(buildAwardTimes(awardTimes,t.getActivityId()));

        return true;
    }


    @Override
    public List queryAwardInfo(T t) {
        List<AwardPrize> awardPrizeList = awardPrizeService.queryAwardInfo(t.getActivityId());
        return awardPrizeList;
    }

    @Override
    public boolean checkPrizeLimit(T t) {
        List<AwardPrize> awardPrizeList = awardPrizeService.queryAwardInfo(t.getActivityId());
        AwardPrize awardPrize = awardPrizeList.get(1);

        //检查限制奖品数量 O(1)
        redisTemplate.opsForSet().isMember("activity:awardLimit:" + awardPrize.getId(),
                LocalDateTime.now().getHour());

        //领取一等奖不能再领
        if (checkDrawLimit(t.getActivityId(), t.getIdNo())) {
            awardPrize = awardPrizeList.get(0);
            log.debug("用户不符合限制条件派发谢谢参与");
        }
        return false;
    }

    @Override
    public void detuctAwardNum(T t) {
        List<AwardPrize> awardPrizeList = queryAwardInfo(t);
        AwardPrize awardPrize = awardPrizeList.get(1);
        //扣减奖品数量 O(1)
        redisTemplate.opsForValue().decrement("activity:awardRemain:" + awardPrize.getId());
    }

    @Override
    public void distributeAward(T t) {
        List<AwardPrize> awardPrizeList = queryAwardInfo(t);
        AwardPrize awardPrize = awardPrizeList.get(1);
        awardDistributeService.distibuteAward(awardPrize);
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
