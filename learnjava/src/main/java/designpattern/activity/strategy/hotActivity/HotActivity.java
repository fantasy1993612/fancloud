package designpattern.activity.strategy.hotActivity;

import designpattern.activity.model.DrawAwardParm;

/**
 * @author: xiangming
 * @date: 2020/02/25 02:55
 * @describetion:
 */
public class HotActivity<T extends DrawAwardParm> implements IHotActivity<T> {


    @Override
    public boolean checkActivity(T t) {
        return true;
    }
}
