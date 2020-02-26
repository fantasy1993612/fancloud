package designpattern.activity.strategy.qualify;

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
    default boolean checkQualify(T t){
        return true;
    }
}
