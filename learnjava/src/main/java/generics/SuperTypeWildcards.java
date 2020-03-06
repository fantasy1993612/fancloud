package generics;

/**
 * @Auther: xiangming
 * @Date: 2020/2/26 18:18
 * @Description:
 */
// generics/SuperTypeWildcards.java
import java.util.*;
public class SuperTypeWildcards {


    static void writeTo(List<? super Fruit> apples) {
        apples.add(new Apple());
        apples.add(new Jonathan());
        // apples.add(new Fruit()); // Error
    }
}

