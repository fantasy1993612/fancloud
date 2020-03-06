package generics;

/**
 * @Auther: xiangming
 * @Date: 2020/2/26 22:45
 * @Description:
 */
// generics/Apply.java

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Apply {
    private static Integer i;
    public static <T, S extends Iterable<T>> void apply(S seq, Method f, Object... args) {
        try {
            System.out.println("方法调用前");
            for(T t: seq)
                f.invoke(t, args);
            System.out.println("方法调用后");
        } catch(IllegalAccessException |
                IllegalArgumentException |
                InvocationTargetException e) {
            // Failures are programmer errors
            throw new RuntimeException(e);
        }
    }
}

