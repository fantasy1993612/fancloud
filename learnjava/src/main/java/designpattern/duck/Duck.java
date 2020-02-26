package designpattern.duck;

import designpattern.fly.FlyBehavior;
import designpattern.quack.QuackBehavior;
import lombok.Data;

/**
 * @author: xiangming
 * @date: 2020/02/24 02:44
 * @describetion:
 */
@Data
public abstract class Duck {

    FlyBehavior flyBehavior;

    QuackBehavior quackBehavior;

    public abstract void display();

    public void performFly(){
        flyBehavior.fly();
    }


    public void performQuack(){
        quackBehavior.quack();
    }



}
