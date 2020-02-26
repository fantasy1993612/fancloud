package designpattern.duck;

import designpattern.fly.FlyNoWay;
import designpattern.quack.Quack;

/**
 * @author: xiangming
 * @date: 2020/02/24 03:02
 * @describetion:
 */
public class ModelDark extends Duck {

    public ModelDark(){
        flyBehavior = new FlyNoWay();
        quackBehavior = new Quack();
    }
    @Override
    public void display() {

    }
}
