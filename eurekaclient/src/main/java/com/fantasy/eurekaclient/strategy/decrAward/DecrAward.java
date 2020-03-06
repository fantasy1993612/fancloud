package com.fantasy.eurekaclient.strategy.decrAward;

import com.fantasy.eurekaclient.model.entity.AwardPrize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * @author: xiangming
 * @date: 2020/03/06 02:09
 * @describetion:
 */
public class DecrAward<T extends AwardPrize> implements IDecrAward<T>{

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public void decrAward(T t) {
        redisTemplate.opsForValue().decrement("activity:awardRemain:" + t.getId(), 1);

    }
}
