package com.fantasy.activity.strategy.distributeAward;

/**
 * @author: xiangming
 * @date: 2020/03/06 02:14
 * @describetion: 奖项派发
 */
public interface IDistributePrize<T> {

    /**
     * 派发奖品
     * @param t
     */
    void distributePrize(T t);
}
