package designpattern.quack;

/**
 * @author: xiangming
 * @date: 2020/02/24 02:47
 * @describetion:
 */
public class MuteQuack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("<Silence>");
    }
}
