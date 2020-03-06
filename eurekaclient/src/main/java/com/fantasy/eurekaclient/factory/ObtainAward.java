package com.fantasy.eurekaclient.factory;
import com.fantasy.eurekaclient.model.params.DrawAwardParam;
import com.fantasy.eurekaclient.strategy.DistributeStrategy;
import com.fantasy.eurekaclient.strategy.DrawAwardStrategy;

/**
 * @author: xiangming
 * @date: 2020/03/02 00:05
 * @describetion:
 */
public class ObtainAward {

    public void distributeAward(){
        DrawAwardParam awardParam = new DrawAwardParam();
        DistributeStrategy distributeStrategy = new DrawAwardStrategy();
        distributeStrategy.checkHotActivity(awardParam);
        distributeStrategy.checkQulify(awardParam);
    }

}
