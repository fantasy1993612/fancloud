package generics.coffee;

/**
 * @author: xiangming
 * @date: 2020/02/26 02:44
 * @describetion:
 */
// generics/coffee/Coffee.java
public class Coffee {
    private static long counter = 0;
    private final long id = counter++;

    @Override
    public String toString() {
        return getClass().getSimpleName() + " " + id;
    }
}
