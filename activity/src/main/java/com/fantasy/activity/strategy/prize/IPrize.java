package com.fantasy.activity.strategy.prize;

import java.util.List;

/**
 * @author: xiangming
 * @date: 2020/03/02 00:13
 * @describetion:
 */
public interface IPrize<T> {

    /**
     * 奖项限制
     * @param t
     * @return
     */
    boolean checkLimitPrize(T t);

    List queryAwardInfo(T t);
}
