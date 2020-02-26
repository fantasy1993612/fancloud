package designpattern.activity.factory;

import designpattern.activity.model.DrawAwardParm;
import designpattern.activity.strategy.hotActivity.IHotActivity;

/**
 * @author: xiangming
 * @date: 2020/02/25 15:33
 * @describetion:
 */
public class Draw<T extends DrawAwardParm> implements DistributeClient<T> {

    private DistributeFactory drawAwardFactory;

    @Override
    public T distributeAward(T t) {
        drawAwardFactory = new DrawAwardFactory();
        IHotActivity hotActivity = drawAwardFactory.getHotActivity(t);
        drawAwardFactory.checkQulify(t);
        drawAwardFactory.detuctNum(t);
        hotActivity.checkActivity(t);
        return t;
    }

}
