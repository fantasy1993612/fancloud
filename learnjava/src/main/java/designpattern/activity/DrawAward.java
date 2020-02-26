package designpattern.activity;

import designpattern.activity.strategy.DistributeStrategy;
import designpattern.activity.strategy.hotActivity.HotActivity;
import designpattern.activity.strategy.hotActivity.IHotActivity;
import designpattern.activity.strategy.qualify.SpringFestivalQualify;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author: xiangming
 * @date: 2020/02/25 02:59
 * @describetion:
 */
@Data
public class DrawAward extends DistributeStrategy {

    @Autowired
    private IHotActivity hotActivity;

    public void DrawAward(){
        qualify = new SpringFestivalQualify();
        hotActivity = new HotActivity();
    }


}
