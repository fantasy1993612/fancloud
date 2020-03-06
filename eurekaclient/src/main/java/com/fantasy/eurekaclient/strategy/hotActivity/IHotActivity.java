package com.fantasy.eurekaclient.strategy.hotActivity;



/**
 * @author: xiangming
 * @date: 2020/02/25 02:54
 * @describetion:
 */
public interface IHotActivity<T> {

    default boolean checkActivity(T t){
        return true;
    }
}
