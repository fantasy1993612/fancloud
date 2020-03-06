package designpattern.activity.strategy.hotActivity;

/**
 * @author: xiangming
 * @date: 2020/02/25 02:55
 * @describetion:
 */
public class HotActivity<T> implements IHotActivity<T> {


    @Override
    public boolean checkActivity(T t) {
        return true;
    }
}
