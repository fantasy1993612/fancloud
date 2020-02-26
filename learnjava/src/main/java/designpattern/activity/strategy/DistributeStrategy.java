package designpattern.activity.strategy;

import designpattern.activity.strategy.hotActivity.IHotActivity;
import designpattern.activity.strategy.qualify.IQualify;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author: xiangming
 * @date: 2020/02/25 03:01
 * @describetion:
 */
@Data
public abstract class DistributeStrategy {

    @Autowired
    protected IHotActivity hotActivity;

    @Autowired
    protected IQualify qualify;
}
