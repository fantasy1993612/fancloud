package com.fantasy.eurekaclient.strategy;

import com.fantasy.eurekaclient.strategy.hotActivity.HotActivity;
import com.fantasy.eurekaclient.strategy.qualify.Qualify;


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
