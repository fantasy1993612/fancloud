package com.fantasy.activity.factory;

/**
 * @author: xiangming
 * @date: 2020/03/02 00:43
 * @describetion:
 */
public class ObtainAwardFactory<T> implements DistributeFactory<T> {

    @Override
    public T disributeAward(T t) {
        IDistributeAward distributeAward = createDistibute();
        distributeAward.checkActivity(t);
        distributeAward.checkQualify(t);
        return t;
    }

    @Override
    public IDistributeAward createDistibute() {
        //return new ObtainAward();
        return null;
    }
}
