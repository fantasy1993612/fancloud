package designpattern.quack;

/**
 * @author: xiangming
 * @date: 2020/02/24 02:46
 * @describetion:
 */
public class Quack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("Quack");
    }
}
