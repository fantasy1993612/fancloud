package designpattern.activity.factory;

import designpattern.activity.strategy.hotActivity.HotActivity;
import designpattern.activity.strategy.hotActivity.IHotActivity;
import designpattern.activity.strategy.qualify.IQualify;
import designpattern.activity.strategy.qualify.SpringFestivalQualify;

import java.util.ArrayList;

/**
 * @author: xiangming
 * @date: 2020/02/25 03:14
 * @describetion:
 */
public class DrawAwardFactory<T> implements DistributeFactory<T>{


    @Override
    public IHotActivity getHotActivity(T t) {
        return new HotActivity();
    }

    @Override
    public IQualify checkQulify(T t) {
        return null;
    }

    @Override
    public void detuctNum(T t) {

    }

    @Override
    public void saveAwardRecord(T t) {

    }
}
