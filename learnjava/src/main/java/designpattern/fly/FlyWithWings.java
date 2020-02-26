package designpattern.fly;

/**
 * @author: xiangming
 * @date: 2020/02/24 02:48
 * @describetion:
 */
public class FlyWithWings implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("I'm flying!!");
    }
}
