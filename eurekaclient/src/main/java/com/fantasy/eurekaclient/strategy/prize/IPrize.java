package com.fantasy.eurekaclient.strategy.prize;

import java.util.List;

/**
 * @author: xiangming
 * @date: 2020/03/02 00:13
 * @describetion:
 */
public interface IPrize<T> {

    boolean checkLimitPrize(T t);

    List queryAwardInfo(T t);
}
