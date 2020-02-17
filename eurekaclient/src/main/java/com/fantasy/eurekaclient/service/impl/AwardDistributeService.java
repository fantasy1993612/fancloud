package com.fantasy.eurekaclient.service.impl;

import com.fantasy.eurekaclient.dao.AwardPrizeRepository;
import com.fantasy.eurekaclient.dao.AwardRecordRepository;
import com.fantasy.eurekaclient.entity.AwardPrize;
import com.fantasy.eurekaclient.entity.AwardRecord;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * @Author: xiangming
 * @Date: 2020-02-06-19:52
 * @Describetion
 */
@Slf4j
@Service
public class AwardDistributeService {


    @Autowired
    private AwardPrizeRepository awardPrizeRepository;

    @Autowired
    private AwardRecordRepository awardRecordRepository;


    @Async
    @Transactional(rollbackFor = Exception.class)
    public void distibuteAward(AwardPrize awardPrize){
        log.info("开始异步派奖");
        //发奖
        awardPrizeRepository.updateAwardRemainNum(awardPrize.getId());

        awardRecordRepository.save(buildAwardRecord());

    }

    private AwardRecord buildAwardRecord(){

        AwardRecord awardRecord = new AwardRecord();
        awardRecord.setAddress("fantasy");
        awardRecord.setActivityId(1);
        awardRecord.setAwardItemName("奶油");
        awardRecord.setAwardItemPrice(new BigDecimal(5.0));
        awardRecord.setTaskId(1);
        awardRecord.setStatus(1);
        awardRecord.setUserPhone("183804478");
        awardRecord.setPrizeName("奶油巧克力哦");
        awardRecord.setUserId("1");
        return awardRecord;
    }
}
