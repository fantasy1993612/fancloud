package designpattern.fly;

/**
 * @author: xiangming
 * @date: 2020/02/24 03:06
 * @describetion:
 */
public class FlyRocketPowered implements FlyBehavior{
    @Override
    public void fly() {
        System.out.println("I am fly with a rocket");
    }
}
