package com.fantasy.eurekaclient.service.impl;

import com.fantasy.eurekaclient.model.entity.AwardTimes;
import com.fantasy.eurekaclient.repository.AwardTimesRepository;
import com.fantasy.eurekaclient.service.IAwardTimesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author: xiangming
 * @date: 2020/02/29 02:25
 * @describetion:
 */
@Service
public class AwardTimesServiceImpl implements IAwardTimesService {

    @Autowired
    private AwardTimesRepository awardTimesRepository;

    @Override
    public Optional<AwardTimes> queryAwardTimes(Integer activityId, String idNo) {
        AwardTimes awardTimes = new AwardTimes();
        awardTimes.setIdNo(idNo);
        awardTimes.setActivityId(activityId);
        Example<AwardTimes> awardTimesExample = Example.of(awardTimes);
        return awardTimesRepository.findOne(awardTimesExample);
    }
}
