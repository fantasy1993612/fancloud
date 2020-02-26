package designpattern.duck;

import designpattern.fly.FlyWithWings;
import designpattern.quack.Quack;

/**
 * @author: xiangming
 * @date: 2020/02/24 02:52
 * @describetion:
 */
public class MallarDuck extends Duck {

    public MallarDuck(){
        quackBehavior = new Quack();
        flyBehavior = new FlyWithWings();
    }

    @Override
    public void display(){
        System.out.println("I am real MallarDuck");
    }
}
