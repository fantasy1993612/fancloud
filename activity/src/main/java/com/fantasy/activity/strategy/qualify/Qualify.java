package com.fantasy.activity.strategy.qualify;

import com.fantasy.activity.model.entity.AwardTimes;
import com.fantasy.activity.repository.AwardTimesRepository;
import com.fantasy.activity.service.IAwardTimesService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

/**
 * @author: xiangming
 * @date: 2020/03/01 23:56
 * @describetion:
 */
public class Qualify<T extends AwardTimes> implements IQualify<T> {

    @Autowired
    private IAwardTimesService awardTimesService;

    @Autowired
    private AwardTimesRepository awardTimesRepository;



    @Override
    public boolean checkQualify(T t) {
        Optional<AwardTimes> awardTimes = awardTimesService.queryAwardTimes(t.getActivityId(),
                t.getIdNo());
        //保存/更新领取次数
        awardTimesRepository.save(buildAwardTimes(awardTimes,t.getActivityId()));
        return false;
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
