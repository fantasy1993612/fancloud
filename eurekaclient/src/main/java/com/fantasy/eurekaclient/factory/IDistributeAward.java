package com.fantasy.eurekaclient.factory;

import com.fantasy.eurekaclient.model.entity.AwardPrize;

import java.util.List;

/**
 * @author: xiangming
 * @date: 2020/03/02 00:30
 * @describetion:
 */
public interface IDistributeAward<T> {

    boolean checkActivity(T t);

    boolean checkQualify(T t);

    List queryAwardInfo(T T);

    boolean checkPrizeLimit(T t);

    void detuctAwardNum(T t);

    void distributeAward(T t);
}
