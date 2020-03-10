package com.fantasy.activity.factory;

import java.util.List;

/**
 * @author: xiangming
 * @date: 2020/02/25 03:13
 * @describetion: 抽奖通用接口
 */
public interface DistributeFactory<T> {

    default Object disributeAward(T t){
        IDistributeAward distributeAward = createDistibute();
        distributeAward.checkActivity(t);
        List award =  distributeAward.queryAwardInfo(t);
        distributeAward.checkQualify(t);
        distributeAward.checkPrizeLimit(t);
        distributeAward.detuctAwardNum(t);
        distributeAward.distributeAward(t);
        return award.get(0);
    }

    IDistributeAward createDistibute();

}
