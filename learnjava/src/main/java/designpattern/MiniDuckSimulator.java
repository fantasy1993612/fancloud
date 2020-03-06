package designpattern;

import designpattern.duck.Duck;
import designpattern.duck.MallarDuck;
import designpattern.duck.ModelDark;
import designpattern.fly.FlyRocketPowered;

/**
 * @author: xiangming
 * @date: 2020/02/24 02:57
 * @describetion:
 */
public class MiniDuckSimulator {

    public static void main(String[] args) {
        Duck duck = new MallarDuck();
        duck.performFly();
        for (int i = 0; i < 10; i++) {

        }

        Duck model = new ModelDark();
        model.performFly();
        //改了
        model.setFlyBehavior(new FlyRocketPowered());
        model.performFly();
    }
}
