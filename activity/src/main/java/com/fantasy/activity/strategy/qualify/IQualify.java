package com.fantasy.activity.strategy.qualify;

/**
 * @author: xiangming
 * @date: 2020/02/25 02:50
 * @describetion:
 */
public interface IQualify<T> {

    /**
     * 资格校验 默认都有资格
     * @return
     */
    boolean checkQualify(T t);
}
