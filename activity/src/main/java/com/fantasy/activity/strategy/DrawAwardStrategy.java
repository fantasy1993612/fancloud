package com.fantasy.activity.strategy;

import com.fantasy.activity.strategy.qualify.Qualify;
import com.fantasy.activity.strategy.hotActivity.HotActivity;


/**
 * @author: xiangming
 * @date: 2020/03/02 02:19
 * @describetion:
 */
public class DrawAwardStrategy<T> extends DistributeStrategy {

    public DrawAwardStrategy() {
        hotActivity = new HotActivity();
        qualify = new Qualify();
    }



}
