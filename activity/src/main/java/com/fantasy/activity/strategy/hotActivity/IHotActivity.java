package com.fantasy.activity.strategy.hotActivity;



/**
 * @author: xiangming
 * @date: 2020/02/25 02:54
 * @describetion:
 */
public interface IHotActivity<T> {

    /**
     * 是否为热门活动
     * @param t
     * @return
     */
    default boolean checkActivity(T t){
        return true;
    }
}
