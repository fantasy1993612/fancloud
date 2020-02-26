package designpattern.activity.strategy.qualify;

/**
 * @author: xiangming
 * @date: 2020/02/25 02:50
 * @describetion: 春节活动
 */
public class SpringFestivalQualify<T> implements IQualify<T>{

    @Override
    public boolean checkQualify(T t){
        return true;
    }
}
