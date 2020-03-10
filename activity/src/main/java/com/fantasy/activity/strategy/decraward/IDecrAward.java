package com.fantasy.activity.strategy.decraward;

/**
 * @author: xiangming
 * @date: 2020/03/06 02:08
 * @describetion: 扣减奖品数量
 */
public interface IDecrAward<T> {

    /**
     * 扣减奖品数量
     * @param t
     */
    void decrAward(T t);

}
