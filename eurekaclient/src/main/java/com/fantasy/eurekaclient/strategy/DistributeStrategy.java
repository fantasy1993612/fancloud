package com.fantasy.eurekaclient.strategy;

import com.fantasy.eurekaclient.strategy.decrAward.IDecrAward;
import com.fantasy.eurekaclient.strategy.distributeAward.IDistributePrize;
import com.fantasy.eurekaclient.strategy.hotActivity.IHotActivity;
import com.fantasy.eurekaclient.strategy.prize.IPrize;
import com.fantasy.eurekaclient.strategy.qualify.IQualify;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author: xiangming
 * @date: 2020/02/25 03:01
 * @describetion:
 */
@Data
public abstract class DistributeStrategy<T> {

    @Autowired
    protected IHotActivity hotActivity;

    @Autowired
    protected IQualify qualify;

    @Autowired
    protected IPrize prize;

    @Autowired
    protected IDecrAward decrAward;

    @Autowired
    protected IDistributePrize distributePrize;

    /**
     * 派发奖品
     * @param t
     */
    public void distributeAward(T t){
        //检查是否为热门活动
        checkHotActivity(t);
        //检查用户资格
        checkQulify(t);
        //检查奖品限制
        checkLimitPrize(t);
        //扣减奖品数量
        decrAward(t);
        //派奖
        distributePrize(t);
    }


    public void checkHotActivity(T t){
        hotActivity.checkActivity(t);
    }

    public void checkQulify(T t){
        qualify.checkQualify(t);
    }

    public void checkLimitPrize(T t){
        prize.checkLimitPrize(t);
    }

    public void decrAward(T t){
        decrAward.decrAward(t);
    }

    public void distributePrize(T t){
        distributePrize.distributePrize(t);
    }



}
