package com.fantasy.activity.strategy.distributeAward;

import com.fantasy.activity.model.entity.AwardRecord;
import com.fantasy.activity.repository.AwardRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;

import java.math.BigDecimal;

/**
 * @author: xiangming
 * @date: 2020/03/06 02:15
 * @describetion:
 */
public class DistributePrize<T> implements IDistributePrize<T> {

    @Autowired
    private AwardRecordRepository awardRecordRepository;

    @Async
    @Override
    public void distributePrize(T t) {
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
