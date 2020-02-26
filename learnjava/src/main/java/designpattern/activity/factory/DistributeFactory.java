package designpattern.activity.factory;

import designpattern.activity.strategy.hotActivity.IHotActivity;
import designpattern.activity.strategy.qualify.IQualify;

/**
 * @author: xiangming
 * @date: 2020/02/25 03:13
 * @describetion:
 */
public interface DistributeFactory<T> {

    IHotActivity getHotActivity(T t);

    IQualify checkQulify(T t);

    void detuctNum(T t);

    void saveAwardRecord(T t);


}
