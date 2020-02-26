package designpattern.activity.strategy.hotActivity;

import designpattern.activity.model.DrawAwardParm;

/**
 * @author: xiangming
 * @date: 2020/02/25 02:54
 * @describetion:
 */
public interface IHotActivity<T extends DrawAwardParm> {

    default boolean checkActivity(T t){
        return true;
    }
}
