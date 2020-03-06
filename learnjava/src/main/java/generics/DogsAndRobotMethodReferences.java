package generics;

/**
 * @Auther: xiangming
 * @Date: 2020/2/26 23:01
 * @Description:
 */
// generics/DogsAndRobotMethodReferences.java

// "Assisted Latent Typing"
import java.util.function.*;

class Dog{
        }

class PerformingDogA extends Dog {
    public void speak() { System.out.println("Woof!"); }
    public void sit() { System.out.println("Sitting"); }
    public void reproduce() {}
}

class RobotA {
    public void speak() { System.out.println("Click!"); }
    public void sit() { System.out.println("Clank!"); }
    public void oilChange() {}
}

class CommunicateA {
    public static <P> void perform(P performer,
                                   Consumer<P> action1, Consumer<P> action2) {
        action1.accept(performer);
        action2.accept(performer);
    }
}

public class DogsAndRobotMethodReferences {
    public static void main(String[] args) {
        CommunicateA.perform(new PerformingDogA(),
                PerformingDogA::speak, PerformingDogA::sit);
        CommunicateA.perform(new RobotA(),
                RobotA::speak, RobotA::sit);
    }
}
/* Output:
Woof!
Sitting
Click!
Clank!
*/
