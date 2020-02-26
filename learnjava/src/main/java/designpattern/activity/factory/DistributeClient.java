package designpattern.activity.factory;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author: xiangming
 * @date: 2020/02/25 15:30
 * @describetion:
 */
public interface DistributeClient<T> {

    T distributeAward(T t);
}
