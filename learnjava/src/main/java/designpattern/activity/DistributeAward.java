package designpattern.activity;

import designpattern.activity.factory.DistributeClient;
import designpattern.activity.factory.Draw;
import designpattern.activity.model.DrawAwardParm;


/**
 * @author: xiangming
 * @date: 2020/02/25 02:47
 * @describetion:
 */
public class DistributeAward {

    private DistributeClient distributeClient;

    public void distributeAward(String type) {
        DrawAwardParm drawAwardParm = new DrawAwardParm();
        if (type.equals("drawAward")) {
            distributeClient = new Draw();
            distributeClient.distributeAward(drawAwardParm);
        }
        if (type.equals("award")) {

        }


    }
}
